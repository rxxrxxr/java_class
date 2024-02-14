package org.example;

import java.util.Optional;

public class Main9 {
    public static void main(String[] args) {
        Optional<ContInfo> contInfo = Optional.of(new ContInfo(null, "Republic of Korea"));

        String phone = contInfo.map(contInfo1 -> contInfo1.getPhone()).orElse("폰번호 없음");
        String addr = contInfo.map(contInfo1 -> contInfo1.getAddr()).orElse("주소 없음");

        System.out.println(phone);
        System.out.println(addr);

    }
}
