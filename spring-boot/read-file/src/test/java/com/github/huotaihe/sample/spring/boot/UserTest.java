package com.github.huotaihe.sample.spring.boot;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

/**
 * @author 寒溪
 * @date 2022/08/12
 */
@Slf4j
public class UserTest {

    @Test
    public void testReadUserFormFile() throws IOException {

        String user = IOUtils.toString(UserTest.class.getResourceAsStream("user.json"),
            StandardCharsets.UTF_8);


        log.info(user);

    }

}
