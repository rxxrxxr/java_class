package org.example;

/*
    import java.lang.*;
    기본생성자 생략가능 -> 다른생성자 선언하면 기본생성자 생략불가
    super(); -> 생략가능
    toString(); -> 생략가능 
 */
class MobilePhone {
    protected String number;

    // 다른생성자 선언시 기본생성자 생략 불가..
//    public MobilePhone(){}
    public MobilePhone(String number) {

        this.number = number;
    }

    public void answer() {
        System.out.println("번호는 " + number);

    }
}

class SmartPhone extends MobilePhone {
    private String androidver;

    public SmartPhone(String number, String ver) {
        super(number);
        this.androidver = ver;
    }

    public void playapp() {
        System.out.println("앱 실행할 안드로이드 버전은 " + androidver);
    }
}

public class Main2 {
    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone("010-1111-2222", "1.0");
        sp.playapp();
        sp.answer();
    }
}
