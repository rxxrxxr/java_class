package org.example;

class SmartPhone extends MobilePhone {
    private String androidver;

    public SmartPhone(String number, String ver) {
        super(number);
        this.androidver = ver;
    }

    public void playapp() {
        System.out.println("앱 실행할 안드로이드 버전은 " + androidver);
    }
}