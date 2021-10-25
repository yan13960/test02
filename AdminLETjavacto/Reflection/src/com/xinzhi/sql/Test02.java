package com.xinzhi.sql;

/**
 *
 */
public class Test02 {
    public static void main(String[] args) {

        Test.driverName="AAA";
        System.out.println(Test.driverName);

        Test test=new Test();
        test.driverName="BBB";
        System.out.println(test.driverName);
    }
}
