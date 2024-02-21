package org.example;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

        Runnable task1 = () ->{
            for (int i = 0; i < 1000; i++){
                count.incre();
            }
        };

        Runnable task2 = () ->{
            for (int i = 0; i < 1000; i++){
                count.decre();
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start(); // run을 start로 실행함
        t2.start();

        t1.join(); // t1스레드가 끝나는걸 기다린다
        t2.join(); // t2스레드가 끝나는걸 기다린다
        System.out.println(count.getCnt());
    }
}
