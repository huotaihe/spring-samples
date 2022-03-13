package com.huotaihe.sample.spring.boot.powermock;

import com.huotaihe.sample.spring.boot.powermock.model.Dog;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author 寒溪
 * @date 2021/06/25
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Dog.class})
public class MockFinalClassTest {

    @Test
    public void testSpeak() {
        Dog dog = PowerMockito.mock(Dog.class);
        PowerMockito.when(dog.speak()).thenReturn("Test speak.");

        Assert.assertEquals(dog.speak(),"Test speak.");
    }

}
