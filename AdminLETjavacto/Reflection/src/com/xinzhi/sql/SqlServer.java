package com.xinzhi.sql;

/**
 *
 */
public class SqlServer implements Source{
    @Override
    public void select() {
        System.out.println("从sqlsercver里边查找数据");
    }
}
