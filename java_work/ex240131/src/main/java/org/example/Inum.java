package org.example;

public class Inum {

    private int num;

    public Inum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object obj) {
        return this.num == ((Inum)obj).num;
    }
}
