package com.huotaihe.sample.spring.boot.powermock;

import com.huotaihe.sample.spring.boot.powermock.model.SpyDemo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author 寒溪
 * @date 2021/06/26
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(SpyDemo.class)
public class MockSpyClassTest {

    @Test
    public void method1() {
        PowerMockito.spy(SpyDemo.class);
        PowerMockito.when(SpyDemo.method1()).thenReturn(false);
        Assert.assertFalse(SpyDemo.method1());
        Assert.assertTrue(SpyDemo.method2());
    }
}
