package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main6 {

    public static void main(String[] args) {
        Map<Integer,String> map1 = new HashMap<>();

        map1.put(10,"홍길동");
        map1.put(20,"박길동");
        map1.put(30,"김길동");

        System.out.println(map1.get(10));
        System.out.println(map1.get(20));
        System.out.println(map1.get(30));

        System.out.println();

        Map<String,String> map2 = new HashMap<>();

        map2.put("aa","홍길동");
        map2.put("bb","박길동");
        map2.put("cc","김길동");

        System.out.println(map2.get("aa"));
        System.out.println(map2.get("bb"));
        System.out.println(map2.get("cc"));

    }
}
