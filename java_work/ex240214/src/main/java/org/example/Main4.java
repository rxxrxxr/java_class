package org.example;

import java.util.function.Function;

public class Main4 {
    public static void main(String[] args) {
        Function<char[],String> function = chars -> new String(chars);

        Function<char[],String> function1 = String::new;

        String string = function.apply(new char[]{'R','O','B','O','T'});
        System.out.println(string);

        String string1 = function.apply(new char[]{'B','A','N','A','N','A'});
        System.out.println(string1);

    }
}
