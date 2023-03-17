package com.springaop.example6;

import com.springaop.example2.Log;

@Log
public class TestServiceImpl implements TestService {

    @Override
    public void test() {

    }

    @Override
    public void test(int i) {

    }

    @Override
    public void test(int i, String s) {

    }

    @Override
    public void test(String s1, int i, String s2) {

    }

    @Override
    public void test(String s1, String s2, int i, String s3) {

    }

    @Override
    public void test(Loggable l) {

    }

    @Override
    public void test(String a, String b, String c, int i, String d, String e) {


    }
}
