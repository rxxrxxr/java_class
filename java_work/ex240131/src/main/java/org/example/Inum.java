package org.example;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;
@ToString
@Getter
public class Inum implements Comparable {

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

    // Arrays.sort 호출하면 기본형(int,double) 타입 정렬이 된다
    // 객체형타입(Inum,Person)을 정렬하고
    // conparable 상속받아서 conpareTo 재정의한다
    @Override
    public int compareTo(Object o) {
        return this.num - ((Inum) o).num; // 오름차순
                                          // 내림차순은 반대로
    }
}
