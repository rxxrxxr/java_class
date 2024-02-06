package org.example;

// enum 도 클래스이다
enum Person {
    MAN(10, "김길동"), WOMAN(20, "이순자");
    private int age;
    private String name;

    Person(int age, String name) {
        this.name = name;
        this.age = age;
        System.out.println("생성자 호출");
    }

    @Override
    public String toString() {
        return "Person age " + age + " Person name " + name;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Person.MAN);
        System.out.println(Person.WOMAN);

    }
}