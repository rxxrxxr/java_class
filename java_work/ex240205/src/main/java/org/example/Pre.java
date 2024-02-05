package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pre {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("robot","toy","box","weapon");

        Collections.sort(list);
        System.out.println(list);
    }
}
