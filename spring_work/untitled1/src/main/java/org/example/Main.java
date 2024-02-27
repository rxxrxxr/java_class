package org.example;

class doB{
    public static void BB(){
        System.out.println("뭐하니");
    }
}

public class Main {
    public static void main(String[] args) {
        doA aa = new doA();

        aa.AA();

        doB.BB();

    }
}