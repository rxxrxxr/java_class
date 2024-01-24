package org.example;

import java.util.List;

public class Main3 {

    public static void doA(Printable prn){
        prn.print();
    }

    public static void main(String[] args) {
        doA( ()->{ System.out.println("함수"); } );

        List<String> list =
                List.of("aa","bb","cc");

        list.stream().forEach( (item)->{
            System.out.println(item);
        });

        System.out.println();
        
        list.stream()
                .filter( item-> item.contains("aa"))
                .forEach(System.out::println);
    }
}
