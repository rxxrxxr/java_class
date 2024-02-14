package org.example;

import java.util.Optional;

public class Main6 {
    public static void main(String[] args) {
        Optional<String> optional1 = Optional.of("TOY");
        Optional<String> optional2 = Optional.ofNullable(null);
        Optional<String> optional3 = Optional.empty(); // 보통 null을 넣을때는 empty를 많이 쓴다
        // 방법 1
//        if(optional1.isPresent())
//            System.out.println(optional1.get());
//        if(optional2.isPresent())
//            System.out.println(optional2.get());
//        if(optional3.isPresent())
//            System.out.println(optional3.get());

        // 방법 2
        optional1.ifPresent(string -> System.out.println(string));
        optional2.ifPresent(string -> System.out.println(string));
        optional3.ifPresent(string -> System.out.println(string));



    }
}
