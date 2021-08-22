package ua.hillel.homeworks.hw9;

import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void run () {
        Map<String, Integer> productList = new HashMap<>();
        productList.put("Bread", 3);
        productList.put("Tea",5);
        productList.put("Coffee",1);
        productList.put("Cheese",2);
        productList.put("Fruits", 10);

        int productCount = 0;
        for (Map.Entry<String, Integer> productItem : productList.entrySet()) {
            productCount = productCount + productItem.getValue();
        }


        System.out.println(productCount);
    }
}
