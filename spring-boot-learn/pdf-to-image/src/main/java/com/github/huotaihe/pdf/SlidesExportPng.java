package com.github.huotaihe.pdf;

import java.io.InputStream;

import com.aspose.slides.*;

public class SlidesExportPng {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = PdfPlaceHolderReplace.class.getClassLoader().getResourceAsStream("poster.pptx");
        // 加载PPT文件
        Presentation presentation = new Presentation(inputStream);

        // 遍历每一张幻灯片并导出为PNG
        for (int i = 0; i < presentation.getSlides().size(); i++) {
            Slide slide = presentation.getSlides().get_Item(i);
            slide.saveToSVG("/tm/" + i + ".svg");
        }
    }
}
