package org.example;
/*
    List 컬렉션 ROBOT, APPLE, BANANA
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("ROBOT", "APPLE", "BANANA", "BOX", "AA");
        list = new ArrayList<>(list);

        // Arrays.sort 배열을 정렬
        Collections.sort(list);

//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });

        // 람다
        Collections.sort(list, (o1, o2) -> o1.length() - o2.length());

        // for문
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        // 스트림
        list.stream().forEach(s -> System.out.print(s + " "));

    }
}