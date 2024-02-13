package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main9 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa","bbb","ccc");
        list = new ArrayList<>(list);

        list.removeIf(string -> string.equals("aaa"));
        System.out.println(list);

        Optional<String> string = Optional.of("aaa");
        string.ifPresent(string1 -> System.out.println(string1));

    }
}
