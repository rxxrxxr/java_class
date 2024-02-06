package org.example;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
//        insert가 static일때 바로 호출가능
//        Enum_Study_DB.insert();
        while (true) {
            Enum_Study_DB enumStudyDb = new Enum_Study_DB();
            enumStudyDb.insert();
            enumStudyDb.select();

            Scanner sc = new Scanner(System.in);
            System.out.print("수정하고 싶은 id > ");
            int temp = sc.nextInt();

            enumStudyDb.update(temp);
            enumStudyDb.select();

            System.out.print("삭제하고 싶은 id > ");
            temp = sc.nextInt();
            enumStudyDb.delete(temp);
            enumStudyDb.select();
        }
    }
}
