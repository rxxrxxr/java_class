package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
// Collection.sort
// comparable -> CompareTo
// Collection.sort( 컬렉션, comparator);
// interface 객체는 생성을 하려고 안에있는 함수를 재정의
public class Ex02 {
    public static void main(String[] args) {
        List<Car> list = Arrays.asList(new Car(1800),
                                       new Car(3000),
                                       new Car(4000),
                                       new Car(1200)
        );

//        Collections.sort(list); // Collections 정렬

//        Collections.sort(list, // Comparator 정렬
//                new Comparator<Car>() {
//                    @Override
//                    public int compare(Car o1, Car o2) {
//                        return ((Car)o2).getDisp() - ((Car)o1).getDisp();
//                    }
//                }
//        );

        Collections.sort(list, // 람다 정렬
                  (a,b) ->
                          ((Car)a).getDisp() - ((Car)b).getDisp());

        System.out.println(list);
    }

}
