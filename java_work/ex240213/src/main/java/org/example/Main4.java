package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main4 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 7, 9, 12, 24);
        int sum = 0;

        sum = doSum(item -> item % 2 == 0, list);
        System.out.println("sum = " + sum);

        sum = doSum(item -> item % 2 != 0, list);
        System.out.println("sum = " + sum);

        sum = list.stream().mapToInt(integer -> integer).sum();
        System.out.println(sum);

        sum = list.stream().filter(integer -> integer % 2 == 0).mapToInt(Integer -> Integer).sum();
        System.out.println(sum);

        // 위아래 똑같은 결과값
        sum = 0;
        for (int i : list){
            if(i % 2 ==0){
                sum += i;
            }
        }
        System.out.println(sum);

    }

    // Predicate<Integer> = IntPredicate, String은 제네릭을 써서 표현
    private static int doSum(Predicate<Integer> p, List<Integer> list) {
        int s = 0;

        for (int i : list) {
            if (p.test(i)) {
                s += i;
            }
        }

        return s;
    }
}
