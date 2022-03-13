package com.huotaihe.sample.spring.boot.powermock;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

/**
 * @author 寒溪
 * @date 2021/06/25
 */
public class PowermockSamplesTest {

    /**
     * 第一个测试用例
     */
    @Test
    public void helloWorld() {

        List list = PowerMockito.mock(List.class);
        PowerMockito.when(list.size()).thenReturn(100);
        Assert.assertEquals(list.size(), 100);
    }

}
