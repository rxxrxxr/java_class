package org.example;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main7 {
    public static void main(String[] args) {
        // 현재 지역 시간 출력
        ZonedDateTime here = ZonedDateTime.now();

        System.out.println(here);

        // 유렵/파리의 시간 출력
        ZonedDateTime paris = ZonedDateTime
                .of(here.toLocalDateTime(),
                        ZoneId.of("Europe/Paris"));
        System.out.println(paris);

        // 두 지역의 시간차
        Duration diff = Duration.between(here, paris);
        System.out.println(diff);

    }
}
