package org.example;

import java.util.Arrays;
import java.util.List;

class Toy {
    private String name;
    private int price;

    public Toy(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

public class Main6 {
    public static void main(String[] args) {
        List<Toy> list = Arrays.asList(new Toy("로봇", 13000),
                new Toy("총", 5000),
                new Toy("인형", 8000));
        // sum
        int sum = list.stream().filter(toy -> toy.getPrice() < 10000)
                .mapToInt(value -> value.getPrice())
                .sum();
        System.out.println(sum);
        // reduce
        System.out.println();
        sum = list.stream().filter(toy -> toy.getPrice() < 10000)
                .mapToInt(value -> value.getPrice())
                .reduce(0, (left, right) -> left + right);
        System.out.println(sum);

    }
}
