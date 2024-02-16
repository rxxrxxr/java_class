package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Predicate;

public class Main4 {
    public static void main(String[] args) {
        // 현재 날짜
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        // LocalDate.of() / 특정 날짜 출력( 크리스 마스 )
        LocalDate xmas = LocalDate.of(localDate.getYear(), 12, 25);
        System.out.println(xmas);

        // .minusDays / n만큼 날짜를 뺀다
        LocalDate eve = xmas.minusDays(1);
        System.out.println(eve);

        // Period / localDate에서 xmas 까지 남은 날짜를 구한다
        Period period = Period.between(localDate, xmas);
        System.out.println(period);

        // .getMonths()와 .getDays()를 써서 숫자만 표현한다
        System.out.println(period.getMonths() + "월" + period.getDays() + "일");


    }
}
