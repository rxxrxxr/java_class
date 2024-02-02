package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        System.out.println(list);

        // 불변객체이기 때문에 넣을수가 없다

        List<String> mylist = new ArrayList<>(list);
        mylist.add("eee");

        mylist.addAll(Arrays.asList("fff","ggg","hhh"));

        System.out.println(mylist);

        List<String> list3 = new LinkedList<>(list);

        List<Integer> list2 = Arrays.asList(111, 222, 333);
//        list2.add(444);


    }
}
