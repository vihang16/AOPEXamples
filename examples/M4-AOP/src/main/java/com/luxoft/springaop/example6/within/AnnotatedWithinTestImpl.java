package com.luxoft.springaop.example6.within;

import com.luxoft.springaop.example2.Log;

@Log
public class AnnotatedWithinTestImpl implements WithinTest {

    @Override
    public void test() {

    }

    @Override
    public void test(String s) {

    }

    @Override
    public void superTest(String s) {

    }
}
