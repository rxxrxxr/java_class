package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
// comparable -> compareTo 재정의
// comparator -> 재정의
// 람다를 쓰기위한 준비작업

public class Ex04 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("BOX", "ROBOT", "APPLE");
        list = new ArrayList<>(list);

        List<String> copyList = Arrays.asList(new String[list.size()]);
        Collections.copy(copyList, list);
        System.out.println(copyList);
        System.out.println();

        List<String> tlist = list.stream().filter(s -> s.length() == 5).toList();
        List<Integer> olist = list.stream().map(s -> s.length()).toList();
        copyList.set(0, "aaa");
        System.out.println(list);
        System.out.println(copyList);
        System.out.println(tlist);
        System.out.println(olist);
        System.out.println();
        // 문자열 정렬
        Collections.sort(list);
        System.out.println(list);
        // 위치 찾아내기 binarySearch는 정렬을 하고나서 써야한다
        int idx = Collections.binarySearch(list, "ROBOT");
        System.out.println(idx);
        System.out.println(list.get(idx));

    }
}
