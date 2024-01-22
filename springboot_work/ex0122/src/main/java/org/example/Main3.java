package org.example;

class SuperCls{
    static int count = 0;
}
class SubCls extends SuperCls{
    public static void setCount(){
        count = 100;
    }
}
public class Main3 {
    public static void main(String[] args) {
        System.out.println(SuperCls.count);
        System.out.println(SubCls.count);

        SuperCls.count = 200;

        System.out.println(SuperCls.count);
        System.out.println(SubCls.count);

//        SubCls sc = new SubCls();
//        sc.setCount();
        SubCls.setCount();
        System.out.println(SuperCls.count);
        System.out.println(SubCls.count);
    }
}
