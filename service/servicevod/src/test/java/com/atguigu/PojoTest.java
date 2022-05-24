package com.atguigu;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 创建人: 以飞飞飞
 * 创建日期: 2022/5/21 17:36
 */

public class PojoTest {
    public static void main(String[] args) {
        List<pojo> list=new Vector<>();
        pojo bu=new pojo();
        bu.setAge("13");
        bu.setName("张三");
        bu.setSex("男");
        pojo se=new pojo();
        se.setAge("13");
        se.setName("李四");
        se.setSex("女");
        list.add(0, bu);
        list.add(1, se);

        //System.out.println(list.get(1));


        String[] str=new String[]{"1","2","3"};
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
