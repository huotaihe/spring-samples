package com.huotaihe.sample.spring.boot.powermock;

import com.huotaihe.sample.spring.boot.powermock.model.SpyObjectDemo;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

/**
 * @author 寒溪
 * @date 2021/06/26
 */
public class MockSpyObjectTest {

    @Test
    public void test() {
        SpyObjectDemo spyObjectDemo = PowerMockito.spy(new SpyObjectDemo());
        PowerMockito.when(spyObjectDemo.method1()).thenReturn(false);

        Assert.assertTrue(spyObjectDemo.method1());
        Assert.assertTrue(spyObjectDemo.method2());

    }

}
