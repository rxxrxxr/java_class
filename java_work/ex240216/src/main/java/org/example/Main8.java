package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main8 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        // 년/월/일/시간/분 표현
        System.out.println(now.format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm")));
        // 년/월/일 까지만 표현
        System.out.println(now.format(DateTimeFormatter.ofPattern("YYYY-MM-DD")));
    }
}
