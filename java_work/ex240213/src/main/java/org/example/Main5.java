package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

// 50개의 랜덤한 숫자중에서 5개의 숫자 뽑기
// Supplier
public class Main5 {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> {
            return new Random().nextInt(50);
        };
        List<Integer> list = doList(s, 5);
        System.out.println(list);
    }

    private static List<Integer> doList(Supplier<Integer> s, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(s.get());
        }
        return list;
    }
}
