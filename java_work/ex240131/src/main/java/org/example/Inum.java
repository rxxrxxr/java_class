package org.example;

import java.util.Objects;

public class Inum {

    private int num;

    public Inum(int num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        return 1020;
    }

    @Override
    public boolean equals(Object obj) {
        return this.num == ((Inum)obj).num;
    }
}
