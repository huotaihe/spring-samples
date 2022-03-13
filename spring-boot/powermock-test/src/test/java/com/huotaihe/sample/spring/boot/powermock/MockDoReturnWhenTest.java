package com.huotaihe.sample.spring.boot.powermock;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

/**
 * @author 寒溪
 * @date 2021/06/26
 */
@Slf4j
public class MockDoReturnWhenTest {

    /**
     * 返回期望值
     */
    @Test
    public void returnExceptedValue() {
        List<String> list = PowerMockito.mock(List.class);
        PowerMockito.doReturn("a").when(list).get(0);
        Assert.assertEquals("a", list.get(0));
        Assert.assertEquals("a", list.get(1));
    }

    @Test(expected = NullPointerException.class)
    public void returnExceptedException() {
        List<String> list = PowerMockito.mock(List.class);
        PowerMockito.doThrow(new NullPointerException()).when(list).get(0);
        log.info("Test result");
        Assert.assertEquals("a", list.get(0));
        Assert.assertEquals("a", list.get(1));
    }

    @Test
    public void returnExceptedAnswer() {
        List<String> list = PowerMockito.mock(List.class);
        PowerMockito.doAnswer(invocation -> invocation.getArgument(0) + "_a").when(list).get(0);
        log.info("Test result");
        Assert.assertEquals("0_a", list.get(0));
    }

    @Test
    public void returnNothing() {
        List<String> list = PowerMockito.mock(List.class);
        PowerMockito.doNothing().when(list).clear();
        log.info("Test result");
        list.clear();
        Mockito.verify(list).clear();
    }

    @Test
    public void invokeRealMethod(){

        List<String> list = new ArrayList<>();
        list.add("b");
        list.add("c");

        List<String> mockList = PowerMockito.spy(list);
        PowerMockito.doCallRealMethod().when(mockList).get(0);
        log.info("Test result");
        Assert.assertEquals("b", mockList.get(0));
    }



}
