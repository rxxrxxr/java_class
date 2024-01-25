package org.example;

interface Printable {
    int a = 10;

    public void print(String doc);
    default public void doA(){
        System.out.println("doA 메서드 입니다");
    }
}

interface CMYKPrintable extends Printable{
    public void printCMYK(String doc);
}
class PRN990 implements CMYKPrintable{

    @Override
    public void print(String doc) {
        System.out.println("S Print 흑백출력합니다.");
        System.out.println(doc);
    }

    @Override
    public void printCMYK(String doc) {
        System.out.println("S Print 컬러출력합니다.");
        System.out.println(doc);
    }
}

class SPrint implements Printable {
    @Override
    public void print(String doc) {

        System.out.println("S Print 출력합니다.");
        System.out.println(doc);
    }
}

class LPrint implements Printable {
    @Override
    public void print(String doc) {

        System.out.println("L Print 출력합니다.");
        System.out.println(doc);
    }
}

public class Main {
    public static void main(String[] args) {
        String doc = "REPORT";

        SPrint sp = new SPrint();
        sp.print(doc);
        LPrint lp = new LPrint();
        lp.print(doc);

        Printable p1 = (d) -> {
            System.out.println("람다");
        };
        p1.print(doc);

        PRN990 prn990 = new PRN990();
        prn990.print("흑백출력");
        prn990.printCMYK("컬러출력");

    }
}













