package org.example;

import java.util.Arrays;
import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        Person person1 = new Person("홍길동", 20);
        Person person2 = new Person("김길동", 30);
        Person person3 = new Person("박길동", 40);
        Person person4 = new Person("이길동", 50);

        List<Person> list = Arrays.asList(person1, person2, person3, person4);
        list.stream().filter(person -> person.getAge() == 20)
                .forEach(System.out::println);

        // for문
        for (Person person : list){
            if(person.getAge() == 20){
                System.out.println(person);
            }
        }
    }
}
