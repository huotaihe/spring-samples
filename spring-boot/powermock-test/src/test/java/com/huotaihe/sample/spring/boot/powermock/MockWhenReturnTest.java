package com.huotaihe.sample.spring.boot.powermock;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

/**
 * @author 寒溪
 * @date 2021/06/26
 */
@Slf4j
public class MockWhenReturnTest {

    @Test
    public void testMockValue() {
        Integer value = 100;

        List<Integer> list = PowerMockito.mock(List.class);
        PowerMockito.when(list.get(0)).thenReturn(value);
        Assert.assertEquals(list.get(0), value);
        Assert.assertEquals(list.get(1), value);
    }

    @Test(expected = NullPointerException.class)
    public void testMockException() {
        List<Integer> list = PowerMockito.mock(List.class);
        PowerMockito.when(list.get(0)).thenThrow(new NullPointerException());
        log.info("Test throw exception.");
    }

    @Test
    public void testMockAnswer() {
        List<Integer> list = PowerMockito.mock(List.class);
        PowerMockito.when(list.get(0)).thenAnswer(invocation -> {
            Integer value = invocation.getArgument(0);
            return value * 100;
        });

        Assert.assertEquals(list.get(0), Integer.valueOf(0));
        Assert.assertEquals(list.get(2), Integer.valueOf(2 * 100));
    }

    @Test
    public void testRealMethod() {

        List<String> list = new ArrayList<>();
        list.add("a");

        List<String> mockList = PowerMockito.spy(list);
        PowerMockito.when(mockList.get(0)).thenCallRealMethod();
        Assert.assertEquals(mockList.get(0), "a");
    }
}
