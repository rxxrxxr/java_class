package org.example;

import java.util.function.Consumer;

interface AA {
    public void doA();
}

// Consumer의 기본형태, 만들어져 있어서 다시 정의할 필요가 없다
//interface MyConsummer<T>{
//    public void accept(T t);
//}

public class Main {
    public static void aa(AA aa, String str) {
        aa.doA();
    }
    public static void aa1(Consumer<String> consumer, String str){
        consumer.accept(str);
    }

    public static void main(String[] args) {
        AA a = () -> {
            System.out.println("안녕하세요");
        };
        a.doA();

        aa(() -> {
            System.out.println("함수 매개변수 보내기"); // 람다를 제일 많이 쓸때 - 함수 매개변수 보낼때
        }, "문자열");

        aa1(string -> {
            System.out.println(string);
        }, "만들어져있어요");

    }
}