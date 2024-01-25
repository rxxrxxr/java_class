package org.example;
interface A{
    public void doA();
    public void doAA();
    default public void doB(){
        System.out.println("A default");
    }
    static public void doC(){
        System.out.println("Static");
    }
}
public class Main2 {
    public static void main(String[] args) {
        A.doC();

        A a = new A() {
            @Override
            public void doA() {
                System.out.println("A doA()");
            }

            @Override
            public void doAA() {

            }
        };
        a.doA();
        a.doB();

//        A a1 = ()->{ // 추상메서드가 2개이상 있으면 람다 못씀
//            System.out.println("람다");
//        };
//        a1.doA();
//        a1.doB();

    }
}
