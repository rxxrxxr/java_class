package org.example;

class MobilePhone{
    protected String number;
    public MobilePhone(){}
    public MobilePhone(String number){
        this.number = number;
    }
    public void answer(){
        System.out.println("대답 번호는 " + number);
    }
}
class SeartPhone extends MobilePhone{

}
public class Main3 {
    public static void main(String[] args) {

    }
}
