package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main5 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("BOX", "ROBOT", "SIMPLE");

        Stream<Integer> integerStream = list.stream().map(string -> string.length());
        integerStream.forEach(System.out::println);

        System.out.println();
        list.stream().map(string -> string + " " + string).forEach(System.out::println);
        list.stream().map(string -> string + " 입니다.").forEach(System.out::println);

        Person person1 = new Person("홍길동", 20);
        Person person2 = new Person("김길동", 30);
        Person person3 = new Person("박길동", 40);
        Person person4 = new Person("이길동", 50);

        System.out.println();
        List<Person> list1 = Arrays.asList(person1, person2, person3, person4);
        list1.stream().map(person -> person.getName()).forEach(System.out::println);

        System.out.println();
        for (Person person : list1) {
            System.out.println(person.getName() + " 입니다");
        }

        // 모든 사람의 나이 합 구하기
        System.out.println();
        int sum = list1.stream().map(person -> person.getAge())
                .reduce(0, (integer, integer2) -> integer += integer2);
        System.out.println(sum);

        // 20살 이상의 합 구하기
        System.out.println();
        int sum1 = list1.stream().map(person -> person.getAge())
                .filter(integer -> integer > 20)
                .reduce(0, (integer, integer2) -> integer += integer2);
        System.out.println(sum1);
    }
}
