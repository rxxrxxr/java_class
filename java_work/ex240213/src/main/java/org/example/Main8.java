package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;

public class Main8 {
    public static void main(String[] args) {

        // String을 받아서 Integer로 출력
        Function<String, Integer> function = string -> string.length();

        System.out.println(function.apply("ROBOT"));
        System.out.println(function.apply("SYSTEM"));

        System.out.println();
        List<String> list = Arrays.asList("ROBOT", "SYSTEM", "TEST");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).length());
        }

        System.out.println();
        list.stream().map(string -> string.length()).forEach(integer -> System.out.println(integer));

        System.out.println();
        IntFunction<String> intFunction = value -> value + "";
        String result = intFunction.apply(10);
        System.out.println(result);

    }
}
