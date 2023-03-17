package com.luxoft.springaop.example6;

import com.luxoft.springaop.example6.within.WithinTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("example6/aop.xml");

        TestService testService = (TestService) context.getBean("testService");
       /* testService.test(10);
        testService.test(10, "test");
        testService.test("test1", 10, "test2");
        testService.test("test1", "test2", 10, "test3");



        testService.test(new Loggable());*/

        WithinTest annotatedWithinTest = (WithinTest) context.getBean("annotatedWithinTest");
        annotatedWithinTest.test();
        /*testService.test("a","b","c",1,"d", "E");

        WithinTest withinTest = (WithinTest) context.getBean("withinTest");
        withinTest.test();
        withinTest.test("test");
        withinTest.superTest("test1");

        annotatedWithinTest.test();
        annotatedWithinTest.test("annotatedWithinTest");
        annotatedWithinTest.superTest("annotatedWithinTest1");*/

    }
}
