package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 문자열을 정렬할 수 있는 LIST를 만들기


public class Ex01 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("BOX","TOY","ROBOT","WEAPON");
        list = new ArrayList<>(list);

        Collections.sort(list); // 문자열 정렬

        System.out.println(list);

    }
}
