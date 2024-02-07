package org.example;

class BB{}
interface Inter{
    public void interfuntion();
}
public class Main6 {
    public void doA(int a, BB b, Inter inter){
        inter.interfuntion();
        System.out.println("test");
    }
    public Main6(){
        doA(100,new BB(), () -> {
            System.out.println("aaa");
        });
    }

    public static void main(String[] args) {
//        Main6 main6 = new Main6();
//        main6.doA();
        new Main6();
    }
}
