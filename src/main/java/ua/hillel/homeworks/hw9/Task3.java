package ua.hillel.homeworks.hw9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task3 {
    public static void run () {
        List<Integer> randomList = createRandomList();
        List<Integer> divide2Box = new ArrayList<>();
        List<Integer> divide3Box = new ArrayList<>();
        List<Integer> allOthersBox = new ArrayList<>();

        for (Integer value : randomList) {
            if (value %2 == 0){
                divide2Box.add(value);
            }

            if (value %3 == 0){
                divide3Box.add(value);
            }

            if (value %2 != 0 && value %3 != 0){
                allOthersBox.add(value);
            }
        }

        System.out.format("числа которые нацело делятся на 2 -> %s%n" , divide2Box);
        System.out.format("числа которые делятся на 3 -> %s%n", divide3Box);
        System.out.format("остальные -> %s%n", allOthersBox);
    }

    private static List<Integer> createRandomList() {
        Random r = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i ++) {
            int randomInt = r.nextInt( 500);
            list.add(randomInt);
        }
        return list;
    }
}
