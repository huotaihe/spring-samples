package com.huotaihe.sample.spring.boot.csv;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Joiner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 寒溪
 * @date 2022/04/22
 */
@RestController
@RequestMapping("/csv")
public class CsvController {

    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream; charset=UTF-8");
        response.setHeader("Content-Encoding", "UTF-8");
        response.setCharacterEncoding("UTF-8");
        String fileName = URLEncoder.encode("我的CSV导出", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".csv");
        PrintWriter os = null;
        try {
            OutputStream outputStream = response.getOutputStream();
            // 输出CSV 标识头 防止乱码
            outputStream.write(0xEF);
            outputStream.write(0xBB);
            outputStream.write(0xBF);
            // now get a PrintWriter to stream the chars.

            os = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            // 输出头
            String header = "测试1,测试2,测试3";
            os.print(header);

            String[][] slice1 = {
                {"测试行1_1", "测试行1_2", "测试行1_3"},
                {"测试行2_1", "测试行2_2", "测试行2_3"},
                {"测试行3_1", "测试行3_2", "测试行3_3"},
            };

            os.print(csvFormat(slice1));

            String[][] slice2 = {
                {"测试行4_1", "测试行4_2", "测试行4_3"},
                {"测试行5_1", "测试行5_2", "测试行5_3"},
                {"测试行6_1", "测试行6_2", "测试行6_3"},
            };
            os.print(csvFormat(slice2));
            os.flush();
            os.close();
        } finally {

        }

    }

    private String csvFormat(String[][] data){
        StringBuffer sb = new StringBuffer();
        for (String[] line : data) {
            sb.append("\n");
            sb.append(Joiner.on(",").join(line));
        }

        return sb.toString();
    }
}
