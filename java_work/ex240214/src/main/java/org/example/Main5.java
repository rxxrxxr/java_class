package org.example;

class Friend {
    String name;
    Company company;

    public Friend(String name, Company company) {
        this.name = name;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }
}
class Company {
    String companyname;
    ContInfo contInfo;

    public Company(String companyname, ContInfo contInfo) {
        this.companyname = companyname;
        this.contInfo = contInfo;
    }

    public String getCompanyname() {
        return companyname;
    }

    public ContInfo getContInfo() {
        return contInfo;
    }
}
class ContInfo {
    String addr;
    String phone;

    public ContInfo(String addr, String phone) {
        this.addr = addr;
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public String getPhone() {
        return phone;
    }
}
public class Main5 {
    public static void main(String[] args) {
        // NullPointerException 상황
        Friend friend = new Friend("홍길동", new Company("AA",null));
        Company company = friend.getCompany();
        ContInfo contInfo = company.getContInfo();
        String addr = contInfo.getAddr(); // null.getAddr이라서 에러


        System.out.println("addr = " + addr);
    }
}
