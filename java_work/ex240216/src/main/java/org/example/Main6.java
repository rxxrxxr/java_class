package org.example;

import java.time.ZoneId;

public class Main6 {
    public static void main(String[] args) {
        // 전세계 지역 시간 목록
        ZoneId.getAvailableZoneIds()
                .stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println();
        // Asia 지역 시간 목록
        ZoneId.getAvailableZoneIds()
                .stream()
                .filter(string -> string.startsWith("Asia"))
                .sorted().forEach(System.out::println);

    }
}
