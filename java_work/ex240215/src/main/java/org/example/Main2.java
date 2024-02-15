package org.example;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main2 {
    // 홀수의 합
    public static void main(String[] args) {
        int [] ar = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(ar);
        IntStream intStream1 = intStream.filter(value -> value % 2 == 1);
        int sum = intStream1.sum();
        System.out.println(sum);

        System.out.println(Arrays.stream(ar).filter(value -> value % 2 == 1).sum());

        sum =  Stream.of(1,2,3,4,5)
                .filter(integer -> integer % 2 ==1)
                .reduce(0,(integer, integer2) -> integer += integer2);
        System.out.println(sum);

    }
}
