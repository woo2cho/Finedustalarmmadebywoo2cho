package com.woo2chocompany.finedustalarmmadebywoo2cho;

import org.junit.Test;

/**
 * Created by user on 2017-07-26.
 */

public class FindDustTest {

    private FindDustInfo findDustInfo;

    @Test
    public void test1() {
        findDustInfo = new FindDustInfo();
        findDustInfo.findDustInfo("서울");

    }
}
