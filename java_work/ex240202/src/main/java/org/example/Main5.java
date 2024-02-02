package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main5 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Toy","Box","ROBOT","Toy");
        System.out.println(list);

        // 중복은 제외
        Set<String> set = new HashSet<>(list);
        System.out.println(set);

        /*
         컬렉션
         List -> ArrayList, LinkedList 순서가 있고 중복허용
         Set -> HashSet, TreeSet 중복 허용하지않음
         */

    }
}
