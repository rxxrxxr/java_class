package org.example;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main10 {
    public static void main(String[] args) {
        System.out.println(IntStream.of(1,3,5,7,9).sum());
        System.out.println(IntStream.of(1,3,5,7,9).count());
        System.out.println(IntStream.of(1,3,5,7,9).average());
        System.out.println(IntStream.of(1,3,5,7,9).max());
        IntStream.of(1,3,5,7,9).min().ifPresent(System.out::println);

        System.out.println();
        double avg = IntStream.of(1,3,5,7,9).average().orElse(0);
        System.out.println(avg);
    }
}
