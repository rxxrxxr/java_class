package org.example;

import java.util.Comparator;

public class Car implements Comparable<Car> {
    public int getDisp() {
        return disp;
    }

    private int disp;


    public Car(int disp) {
        this.disp = disp;
    }

    @Override
    public String toString() {
        return "Car{" + "disp=" + disp + '}';
    }

    @Override
    public int compareTo(Car o) {
        return this.disp - o.disp;
    }
}
