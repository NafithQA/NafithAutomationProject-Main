package org.nafeth.randomTests;

import org.nafeth.base.Configurations;

import java.util.HashMap;

public class RandomTests extends Configurations {

    public static void main(String[] args) {
//        System.out.println("Hello, World!");
//
//        HashMap<Integer,String> map = new HashMap<Integer, String>();
//        String value1 = "Large";
//        map.put(1,value1);
//        String value2 = "Medium";
//        map.put(2,value2);
//
//        System.out.println(map.get(2));
//
//        map.clear();
//
//        map.put(1,value2);
//        map.put(2,value1);
//
//        System.out.println(map.get(2));
//
//        map.replace(1,2);

        HashMap<Integer, String> map = new HashMap<Integer, String>();
        String value1 = "Large";
        String value2 = "Medium";

        map.put(1, value1);
        map.put(2, value2);

        System.out.println(map.get(1));
        System.out.println(map.get(2));

        map.replace(1, value1, value2);
        map.replace(2, value2, value1);

        System.out.println(map.get(1));
        System.out.println(map.get(2));

    }
}
