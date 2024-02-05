package org.example;

//interface Person {
//    int MAN = 1;
//    int WOMAN = 2;
//}

//interface Animal {
//    int DOG = 1;
//    int CAT = 2;
//}
enum Person{
    MAN,WOMAN
}
enum Animal{
    DOG,CAT
}

public class Ex05 {
//    public static void who(int man) {
//        switch (man) {
//            case Person.MAN:
//                System.out.println("남성입니다");
//                break;
//            case Person.WOMAN:
//                System.out.println("여성입니다");
//                break;
//        }
//    }
    public static void who(Person person) {
        switch (person) {
            case MAN:
                System.out.println("남성입니다");
                break;
            case WOMAN:
                System.out.println("여성입니다");
                break;
        }
    }

    public static void main(String[] args) {
        who(Person.MAN);
//        who(Animal.DOG);

    }
}
