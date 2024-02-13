package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(11, 22, 33, 44, 55);
        list1 = new ArrayList<>(list1);

        List<String> list2 = Arrays.asList("aa", "ab", "ac", "ad", "ae");
        list2 = new ArrayList<>(list2);

        // Integer 선언이라 String이 들어오면 에러
//        Predicate<Integer> predicate = (item) -> {
//            return item < 33;
//        };

        // 33보다 작으면 remove
        list1.removeIf(integer -> integer < 33); // {}가 없으면 return ; 생략가능
        System.out.println(list1);
        // aa랑 같지않으면 remove
        list2.removeIf(string -> !string.equals("aa"));
        System.out.println(list2);

    }
}
