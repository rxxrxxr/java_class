package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,5,7,9);
        list = new ArrayList<>(list);

        Collections.reverse(list);
        System.out.println(list);

        Consumer<List<Integer>> consumer = lst -> Collections.reverse(lst);
        consumer.accept(list);

        Consumer<List<Integer>> consumer1 = Collections::reverse; // 메소드 참조 람다를 간략하게 표현
        consumer1.accept(list);

        System.out.println(list);

    }
}