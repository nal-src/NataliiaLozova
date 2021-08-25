package ua.hillel.homeworks.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TaskHw9 {
    public static void task2() {
        Map<String, Integer> productList = new HashMap<>();

        productList.put("Хлеб", 1);
        productList.put("Яблоки", 2);
        productList.put("Сырки", 10);
        productList.put("Вода", 3);
        productList.put("Авокадо", 5);


        int numberItemsInProductList = 0;

        for (Map.Entry<String, Integer> product : productList.entrySet()) {
            numberItemsInProductList = numberItemsInProductList + product.getValue();
        }


        System.out.format("количество товаров в списке = %d", numberItemsInProductList);
    }


    public static void task3() {
        List<Integer> randomList = createRandomList();
        List<Integer> divide2Box = new ArrayList<>();
        List<Integer> divide3Box = new ArrayList<>();
        List<Integer> anotherBox = new ArrayList<>();

        for (Integer number : randomList) {
            boolean isDivide2Or3 = false;

            if (number % 2 == 0) {
                isDivide2Or3 = true;
                divide2Box.add(number);
            }

            if (number % 3 == 0) {
                isDivide2Or3 = true;
                divide3Box.add(number);
            }

            if (!isDivide2Or3) {
                anotherBox.add(number);
            }
        }

        System.out.format("числа которые нацело делятся на 2 -> %s%n" , divide2Box);
        System.out.format("числа которые делятся на 3 -> %s%n", divide3Box);
        System.out.format("остальные -> %s%n", anotherBox);
    }

    private static List<Integer> createRandomList() {
        Random r = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i ++) {
            int randomInt = r.nextInt( 10);
            list.add(randomInt);
        }
        return list;
    }

}
