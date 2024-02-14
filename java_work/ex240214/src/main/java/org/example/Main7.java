package org.example;

import java.util.Optional;

public class Main7 {
    public static void main(String[] args) {
        Optional<String> optional1 = Optional.of("Optional String");
        Optional<String> optional2 = optional1.map(string -> string.toUpperCase());

        System.out.println(optional1.get());
        System.out.println(optional2.get());

        System.out.println(optional1);
        System.out.println(optional2);

        Optional<String> optional3 = optional1.map(string -> string.replace(" ","_")).map(string -> string.toLowerCase());

        System.out.println(optional3);


    }
}
