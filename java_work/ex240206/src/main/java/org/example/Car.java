package org.example;

import lombok.*;

@AllArgsConstructor // 생성자
@Data // getter setter toString 통합
public class Car {
    private String name;

//    public Car(String name) {
//        this.name = name;
//    }

//    @Override
//    public String toString() {
//        return "Car{" + "name='" + name + '\'' + '}';
//    }

//    public String getName() {
//        return name;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }
}
