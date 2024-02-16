package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");

        // before 시간 출력
        Instant before = Instant.now();
        System.out.println(before.getNano());

        // stream으로 list 출력
        list.stream().forEach(System.out::println);

        // after 시간 출력
        Instant after = Instant.now();
        System.out.println(after.getNano());

        // Duration = 시간 차이 계산
        Duration between1 = Duration.between(before, after);
        System.out.println(between1);

        // before에 현재시간 넣음
        before = Instant.now();

        // for문으로 list 출력
        for (String temp : list) {
            System.out.println(temp);
        }

        // after에 현재시간 넣음
        after = Instant.now();

        // 시간 차이 계산
        Duration between2 = Duration.between(before, after);
        System.out.println(between2);

        // 결론 = for와 stream의 list출력에 대한 성능차이는 거의없다

    }
}
