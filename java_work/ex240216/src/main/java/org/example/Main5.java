package org.example;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Main5 {
    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.of(2020, 4, 25, 11, 20);
        LocalDateTime flight1 = LocalDateTime.of(2020, 5, 25, 11, 20);
        LocalDateTime flight2 = LocalDateTime.of(2020, 5, 30, 11, 20);

        LocalDateTime myflight;
        if (flight1.isBefore(flight2))
            myflight = flight1;
        else
            myflight = flight2;

        System.out.println(myflight);

        Period period = Period.between(today.toLocalDate(), myflight.toLocalDate());
        System.out.println(period);

        Duration duration = Duration.between(today.toLocalTime(), myflight.toLocalTime());
        System.out.println(duration);

    }
}
