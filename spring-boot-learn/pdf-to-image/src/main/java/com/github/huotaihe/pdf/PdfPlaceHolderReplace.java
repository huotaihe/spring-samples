package com.github.huotaihe.pdf;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.awt.geom.Rectangle2D;

import javax.imageio.ImageIO;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextShape;


public class PdfPlaceHolderReplace {

    static {
        try {
            // 注册字体
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, PdfPlaceHolderReplace.class.getClassLoader().getResourceAsStream("fonts/Alibaba-PuHuiTi-Medium.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        } catch (Exception e) {
            //log.error("register alibaba font error", e);
            System.out.println(e);
        }
    }

    private static final Map<String, String> placeholders = Map.of(
        "$position", "南分-广州区域",
        "$company", "深圳里弦科技有限公司",
        "$seller", "王迪",
        "$orderType", "新购订单",
        "$price", "9K+",
        "$date", "2024.06.21"
    );

    public static final int SCALE = 5;

    /**
     * 参考文章 https://blog.csdn.net/ABCAA1024/article/details/118435624
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        InputStream inputStream = PdfPlaceHolderReplace.class.getClassLoader().getResourceAsStream("poster.pptx");
        // 加载PPTX文件
        XMLSlideShow ppt = new XMLSlideShow(inputStream);
        Dimension pageSize = ppt.getPageSize();
        // 遍历每一张幻灯片
        for (XSLFSlide slide : ppt.getSlides()) {
             //遍历幻灯片上的每个形状，查找占位符
            //for (XSLFShape shape : slide.getShapes()) {
            //    replaceText(shape);
            //}

            //根据幻灯片大小生成图片
            BufferedImage img = new BufferedImage(pageSize.width,pageSize.height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = img.createGraphics();
            graphics.fill(new Rectangle2D.Float(0, 0, pageSize.width,pageSize.height));
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            slide.draw(graphics);
            //slide.ex

            //图片将要存放的路径
            String absolutePath = "/tmp/" + slide.getSlideNumber() + ".png";
            File jpegFile = new File(absolutePath);
            // 图片路径存放
            //如果图片存在，则不再生成
            if (jpegFile.exists()) {
                continue;
            }
            // 这里设置图片的存放路径和图片的格式(jpeg,png,bmp等等),注意生成文件路径
            FileOutputStream out = new FileOutputStream(jpegFile);

            // 写入到图片中去
            ImageIO.write(img, "png", out);
            out.close();
        }

        // 保存修改后的PPTX文件
        FileOutputStream out = new FileOutputStream("/tmp/path_to_new_presentation.pptx");
        ppt.write(out);
        out.close();
        ppt.close();
    }

    public static void replaceText(XSLFShape shape) {
        if (shape instanceof XSLFTextShape) {
            XSLFTextShape textShape = (XSLFTextShape)shape;
            if (placeholders.containsKey(textShape.getText())) {
                // 替换占位符文本
                textShape.getTextBody().setText(placeholders.get(textShape.getText()));
            } else {
                // 可以继续检查其他占位符并替换
                //textShape.setText(Strings.EMPTY);
            }
            //System.out.println(textShape.getText());
        }
    }
}