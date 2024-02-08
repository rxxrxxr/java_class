package org.example;

interface Calcu {
    void cal(int a, int b);
}

interface RetCalcu {
    int cal(int a, int b);
}

public class Main2 {
    //    public static void doA(Calcu calcu, int a, int b){
//        calcu.cal(a,b);
//    }
    public static void doA(Calcu calcu, int... a) { // 배열에 들어감
        calcu.cal(a[0], a[1]);
    }

    public static void main(String[] args) {
        RetCalcu retCalcu = (a, b) -> a + b; // return 생략가능
        int result = retCalcu.cal(5, 5);
        System.out.println(result);


        doA((a, b) -> System.out.println(a + b), 10, 20);
        doA((a, b) -> System.out.println(a - b), 10, 20);


//        Calcu calcu1 = (a, b) -> System.out.println(a + b);
//        calcu1.cal(10, 20);
//
//        Calcu calcu2 = (a, b) -> System.out.println(a - b);
//        calcu2.cal(10, 20);

    }
}
