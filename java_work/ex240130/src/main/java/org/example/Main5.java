package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main5 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,20,30);
//        List<Integer> list = List.of(10,20,30);

        System.out.println(list);

        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()){
            int temp = itr.next();
            System.out.println(temp);
        }
        // 불변인지 확인
//        list.add(50);

        List<Integer> list2 = new ArrayList<>(list);
        System.out.println(list2);

        list2.add(50);
        System.out.println(list2);

    }

}
