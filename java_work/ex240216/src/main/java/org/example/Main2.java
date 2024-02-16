package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("BOX", "TOY", "ROBOT", "SAMPLE");
        list1 = new ArrayList<>(list1);

        List<String> clist = Arrays.asList("BOX", "TOY", "ROBOT", "SAMPLE");
        clist = new ArrayList<>(clist);

        // 병렬 스트림
        list1.addAll(clist);
        System.out.println(list1);

        // 방법 1
        List<String> list2 = new ArrayList<>();
        for (String temp : list1) {
            if (temp.length() > 3) list2.add(temp);
        }
        System.out.println(list2);
        // 방법 2
        List stream_list = list1.stream()
                .filter(string -> string.length() > 3)
                .collect(
                        ArrayList::new,
                        (objects, string) -> objects.add(string),
                        (objects1, objects2) -> objects1.add(list2));
        System.out.println(stream_list);
        // 방법 3
        List stream_list2 = list1.stream()
                .filter(string -> string.length() > 3)
                .collect(
                        Collectors.toList()
                );
        System.out.println(stream_list2);

    }
}
