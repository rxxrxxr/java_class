package org.example;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main9 {
    public static void main(String[] args) {
        Stream.of(11,55,44,33,22).sorted().forEach(System.out::print);

        System.out.println();
        Stream.of(11,55,44,33,22).sorted((o1, o2) -> o2 - o1)
                .forEach(System.out::print);

        System.out.println();
        IntStream.of(1,3,5,7,9).peek(System.out::print).sum();

        System.out.println();
        IntStream.of(1,3,5,7,9).peek(System.out::print)
                .forEach(System.out::print);

    }
}
