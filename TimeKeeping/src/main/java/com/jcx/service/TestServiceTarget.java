package com.jcx.service;

import org.springframework.transaction.annotation.Transactional;

public class TestServiceTarget implements TestService{

    @Override
    @Transactional
    public void biz1() {
        System.out.println("sql1");
        System.out.println("sql2");
        System.out.println("sql3");

    }

    @Override
    public void biz2() {
        System.out.println("sql4");
        System.out.println("sql5");
    }
}
