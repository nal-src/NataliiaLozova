package ua.hillel.homeworks.hw9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Task1 {
    public static void run () {
        List<Integer> randomList = createRandomList();
        Set<Integer> uniqueList = new HashSet<>(randomList);

        System.out.println(randomList);
        System.out.println(uniqueList);
        System.out.println(randomList.size() - uniqueList.size());

    }

    private static List<Integer> createRandomList() {
        Random r = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i ++) {
            int randomInt = r.nextInt(20);
            list.add(randomInt);
        }
        return list;
    }

}
