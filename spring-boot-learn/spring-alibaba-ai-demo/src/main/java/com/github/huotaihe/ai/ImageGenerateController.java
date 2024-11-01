package com.github.huotaihe.ai;

import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImageOptions;
import org.springframework.ai.image.ImageOptionsBuilder;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class ImageGenerateController {

    private final ImageModel imageModel;

    public ImageGenerateController(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    @GetMapping("/generate-image")
    public String generateImage(@RequestParam String prompt) {
        // 设置图片参数
        ImageOptions options = ImageOptionsBuilder.builder()
            .withWidth(1024)
            .withHeight(1024)
            .withModel("wanx-v1")  // 使用通义万象模型
            .withN(1)
            .build();

        // 创建图像提示
        ImagePrompt imagePrompt = new ImagePrompt(prompt, options);
        // 调用AI生成图片
        ImageResponse response = imageModel.call(imagePrompt);
        // 提取结果中的URL
        String imageUrl = response.getResults().get(0).getOutput().getUrl();

        return imageUrl;
    }
}
