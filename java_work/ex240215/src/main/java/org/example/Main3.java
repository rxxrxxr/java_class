package org.example;

import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) {
        String[] strings = {"홍길동","김길동","박길동"};

        // 람다
        Arrays.stream(strings).forEach(string -> System.out.println(string));
        System.out.println();
        // 메소드 참조
        Arrays.stream(strings).forEach(System.out::println);

        System.out.println();
        // for문
        for (String temp : strings){
            System.out.println(temp);
        }

    }
}
