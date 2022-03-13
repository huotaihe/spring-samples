package com.huotaihe.sample.spring.boot.powermock;

import com.huotaihe.sample.spring.boot.powermock.model.Demo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * mock静态方法
 *
 * @author 寒溪
 * @date 2021/06/25
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Demo.class})
public class MockStaticMethodTest {

    @Test
    public void staticMethod() {
        PowerMockito.mockStatic(Demo.class);
        PowerMockito.when(Demo.staticMethod()).thenReturn("Mock Test");

        Assert.assertEquals(Demo.staticMethod(),"Mock Test");
    }

}
