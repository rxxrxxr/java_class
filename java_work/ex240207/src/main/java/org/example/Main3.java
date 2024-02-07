package org.example;

interface Printable {
    public void print();
}

class Paper {
    private String con;

    public Paper(String con) {
        this.con = con;
    }

    // 지역(로컬) 클래스
    public Printable getPrinter() {
        class Printer implements Printable {
            @Override
            public void print() {
                System.out.println(con);
            }
        }
        return new Printer();
    }

    // 익명 클래스, 메소드 안에 클래스를 넣으니 클래스 이름이 필요없어서 return 을 쓴다
    public Printable getPrinter1() {
        return new Printable() {
            @Override
            public void print() {
                System.out.println(con);
            }
        };
    }

    // 람다
    public Printable getPrinter2() {
        return () -> {
            System.out.println(con);
        };
    }


}

public class Main3 {
    public static void main(String[] args) {
        Paper paper = new Paper("행복합니다");
        Printable printable = paper.getPrinter();
        printable.print();
    }
}
