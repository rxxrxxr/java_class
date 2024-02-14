package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

class JustSort{
    public void sort(List<?> list){
        Collections.reverse(list);
    }
}
public class Main2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,5,7,9);
        list = new ArrayList<>(list);

        JustSort justSort = new JustSort();
//        Consumer<List<Integer>> listConsumer = lst -> justSort.sort(lst);

        Consumer<List<Integer>> listConsumer = justSort::sort;

        listConsumer.accept(list);
        System.out.println(list);

        justSort = null; // 자바 8버전에서는 안됨 17버전에서는 해결됨
    }
}
