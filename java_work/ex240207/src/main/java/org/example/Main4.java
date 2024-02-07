package org.example;

import java.util.*;

class Strcomp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}

public class Main4 {
    public static void main(String[] args) {
        // 불변 객체
        List<String> list = Arrays.asList("aa", "b", "ccc", "dddd", "");
        // 가변 객체 설정
        list = new ArrayList<>(list);

        // 방법 0
        /* Strcomp comp = new Strcomp(); // 똑같다 Collections.sort...
        // 정렬
           Collections.sort(list, new Strcomp());
        */

        // 방법 1
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        Collections.sort(list,comp);

        // 방법 2
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        // 방법 3
        Collections.sort(list, (o1, o2) -> o1.length() - o2.length());

        System.out.println(list);
    }
}
