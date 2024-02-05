package org.example;

import java.util.*;

class MyComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o2.getDisp() - o1.getDisp();
    }
}

public class Ex03 {
    public static void main(String[] args) {
        List<Car> list = Arrays.asList(new Car(1200), new Car(4000), new Car(1800));
        list = new ArrayList<>(list);
        // 첫번째 방법
        Collections.sort(list, new MyComparator());

        // 두번째 방법
        Collections.sort(list, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getDisp() - o1.getDisp();
            }
        });

        // 3번째 방법 람다
        Collections.sort(list, (Car o1, Car o2) -> {
            return o2.getDisp() - o1.getDisp();
        });

        System.out.println(list);
    }
}
