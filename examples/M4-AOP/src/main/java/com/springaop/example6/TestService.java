package com.springaop.example6;

public interface TestService {

    void test();

    void test(int i);

    void test(int i, String s);

    void test(String s1, int i, String s2);

    void test(String s1, String s2, int i, String s3);

    void test(Loggable l);

    void test(String a, String b, String c, int i, String d, String e);
}
