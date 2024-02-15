package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int[] ar = {1,2,3,4,5};

        IntStream intStream = Arrays.stream(ar);
        intStream.forEach(System.out::println);
//        intStream.forEach(value -> System.out.println(value));
        // 한줄로 쓰기
//        Arrays.stream(ar).forEach(value -> System.out.println(value));

        System.out.println();
        List<Integer> list = Arrays.asList(11,22,33,44,55);

        Stream<Integer> integerStream = list.stream();
        integerStream.forEach(System.out::println);
        // 한줄로 쓰기
//        list.stream().forEach(System.out::println);

    }
}