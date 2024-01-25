package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main4 {

    public void doA() {
//        try {
            int[] ar = new int[10];
            ar[11] = 10;
            Scanner sc = new Scanner(System.in);
            System.out.println("숫자 입력하세요");
            int a = sc.nextInt();

            System.out.println("숫자 입력하세요");
            int b = sc.nextInt();

            System.out.println("a/b = " + a / b);
            System.out.println("try구문 끝");
            return;
//        } catch (ArithmeticException e) {
//            System.out.println("0으로 나눌수 없습니다" + e.getMessage());
//        } catch(InputMismatchException ie) {
//            System.out.println("문자입력하면 안됩니다");
//        } catch (Exception e){
//            e.printStackTrace();
//            System.out.println("모든예외");
//        }
//        finally{
//            System.out.println("Good Bye");
//        }
    }

    public static void main(String[] args) {

        Main4 main4 = new Main4();
        try {
            main4.doA();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("강제종료 되어서 여기 실행안됨");

    }
}
