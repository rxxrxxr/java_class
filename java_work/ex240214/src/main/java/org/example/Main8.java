package org.example;

public class Main8 {
    public static void main(String[] args) {
        ContInfo contInfo = new ContInfo(null, "Republic of Korea");

        String phone;
        String addr;

        if (contInfo.getPhone() != null){
            phone = contInfo.getPhone();
        }
        else{
            phone = "There is no phone Number";
        }
        if (contInfo.getAddr() != null){
            addr = contInfo.getAddr();
        }
        else{
            addr = "There is no address";
        }
        System.out.println(phone);
        System.out.println(addr);

    }
}
