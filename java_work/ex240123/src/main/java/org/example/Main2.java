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
public class Main2 {
    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone("010-1111-2222", "1.0");
        sp.playapp();
        sp.answer();

        // 부모객체          // 자식객체
        // 자식은 부모에 담을 수 있다
        // 부모는 자식을 참조할 수 있다
        // 다형성이라고 한다
        MobilePhone mp = new SmartPhone("010-1111-2222", "2.0");
        mp.answer();
    }
}
