package com.huotaihe.sample.spring.boot.powermock;

import com.huotaihe.sample.spring.boot.powermock.model.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

/**
 * @author 寒溪
 * @date 2021/06/25
 */
public class MockCommonClassTest {
    /**
     * 测试普通类
     */
    @Test
    public void commonClass() {

        String name = "animal";

        Animal animal = PowerMockito.mock(Animal.class);
        PowerMockito.when(animal.getName()).thenReturn(name);

        Assert.assertEquals(animal.getName(), name);
    }

}
