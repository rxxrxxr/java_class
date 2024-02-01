package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Arrays.sort();
        // Collection.sort();

        // comparable 인터페이스를 상속 받아서 compareTo 매서드를 재정의 해야한다
        List<Item> list = new ArrayList<>();

        Item item1 = new Item();
        item1.setItem_nm("포도");
        item1.setPrice(1000);

        Item item2 = new Item();
        item2.setItem_nm("사과");
        item2.setPrice(2000);

        Item item3 = new Item();
        item3.setItem_nm("바나나");
        item3.setPrice(3000);

        list.add(item1);
        list.add(item2);
        list.add(item3);

        Collections.sort(list);

        System.out.println(list);

    }
}