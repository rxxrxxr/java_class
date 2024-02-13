package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main7 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(11, 22, 33, 44, 55);

        list.forEach(integer -> System.out.println(integer));

        System.out.println();

        for (int i : list) {
            System.out.println(i);
        }

        System.out.println();

        Consumer<String> consumer = string -> System.out.println(string.length());
        consumer.accept("abcde");
        consumer.accept("123");

        BiConsumer<String, String> biConsumer = (string, string2) -> System.out.println(string + string2);
        biConsumer.accept("안녕하세요"," 반갑습니다");
        biConsumer.accept("안녕히가세요"," 안녕히계세요");

        Consumer<Integer> con = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        // 위아래 코드 똑같음
        Consumer<Integer> con1 = integer -> System.out.println(integer);

    }
}
