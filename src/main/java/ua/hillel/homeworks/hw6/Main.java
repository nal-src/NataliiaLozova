package ua.hillel.homeworks.hw6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator;
        String typeCalculator;

        System.out.println("Введите тип калькулятора: base - базовый, eng - инженерный, fin - финансовый");
        String type = scanner.nextLine();
        switch (type) {
            case "eng":
                calculator = new EngCalculator();
                typeCalculator = "инженерный";
                break;
            case "fin":
                calculator = new FinCalculator();
                typeCalculator = "финансовый";
                break;
            default:
                calculator = new SimpleCalculator();
                typeCalculator = "базовый";
                break;
        }
        System.out.printf("Привет! Ты выбрал %s калькулятор", typeCalculator);
        calculator.run();
    }
}
