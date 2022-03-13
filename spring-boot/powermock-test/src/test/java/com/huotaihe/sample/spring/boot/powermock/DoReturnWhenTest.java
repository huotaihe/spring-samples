package com.huotaihe.sample.spring.boot.powermock;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

/**
 * @author 寒溪
 * @date 2021/07/15
 */
public class DoReturnWhenTest {

    @Test
    public void returnExceptedValue() {
        List<Integer> mockList = PowerMockito.mock(List.class);
        PowerMockito.doReturn(100).when(mockList).get(0);

        Assert.assertTrue(mockList.get(0)==100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void returnExceptedException(){
        List<Integer> mockList = PowerMockito.mock(List.class);
        PowerMockito.doThrow(new IndexOutOfBoundsException()).when(mockList).get(0);

        mockList.get(0);
    }
}
