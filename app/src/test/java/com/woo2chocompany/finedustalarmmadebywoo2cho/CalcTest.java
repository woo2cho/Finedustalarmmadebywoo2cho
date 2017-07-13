package com.woo2chocompany.finedustalarmmadebywoo2cho;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * Created by user on 2017-07-13.
 */
@RunWith(MockitoJUnitRunner.class)
public class CalcTest {
    @Mock
    private Calc calc;

    @Before
    public void setUp() throws Exception {
//        calc = new Calc();
        MockitoAnnotations.initMocks(calc);
    }


    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void sum() throws Exception {
        when(calc.sum(anyInt(), anyInt())).thenCallRealMethod();
//        assertEquals(calc.sum(1,2), 3);
        assertThat(calc.sum(1,2), is(3));
    }

    @Test
    public void multiply() throws Exception {
        when(calc.multiply(2,3)).thenReturn(6);
        assertThat(calc.multiply(2,3), is(6));
    }

}