package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main7 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("BOX", "ROBOT", "COMPLEX", "SIMPLE");

        String result = list.stream() // parallelStream() 병렬구조, 데이터가 많을떄 쓴다
                .reduce("", (string, string2) -> {
                    if (string.length() > string2.length())
                        return string;
                    else
                        return string2;
                });
        System.out.println(result);

    }
}
