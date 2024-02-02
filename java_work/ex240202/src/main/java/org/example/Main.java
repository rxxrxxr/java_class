package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        // 리스트에서 0번째 가져오는법
        List<String> list = new LinkedList<>();
        list.add("test");
        String item = list.get(0);

        // set에서는 get이 없어서 리스트와 같이 쓸수없다
        // set.get 없다
        // hashCode 출력하기
        System.out.println(new String("BOX").hashCode());

        set.add(new String("BOX"));
        set.add("ROBOT");
        set.add(new String("BOX"));
        set.add("TOY");

        System.out.println(set);

        System.out.println();

        Iterator<String> itr = set.iterator();
        while (itr.hasNext()){
            String temp = itr.next();
            System.out.println(temp);
        }

        System.out.println();

        for (String temp : set){
            System.out.println(temp);
        }

    }
}