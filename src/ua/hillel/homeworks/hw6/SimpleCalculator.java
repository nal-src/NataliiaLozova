package ua.hillel.homeworks.hw6;

public class SimpleCalculator extends Calculator {

    @Override
    protected String listOperations() {
        return "+, -, /, *";
    }

    @Override
    protected void calculateResult() {
        float num1;
        float num2;
        float result;
        switch (operation) {
            case "+":
                num1 = getNum("Введи первое число:");
                num2 = getNum("Введи второе число:");
                result = num1 + num2;
                showResult(num1, num2, result);
                break;
            case "-":
                num1 = getNum("Введи первое число:");
                num2 = getNum("Введи второе число:");
                result = num1 - num2;
                showResult(num1, num2, result);
                break;
            case "/":
                num1 = getNum("Введи первое число:");
                num2 = getNum("Введи второе число:");
                if(num2 == 0) {
                    System.out.println("Деление на 0 запрещено");
                    System.exit(0);
                }
                result = num1 / num2;
                showResult(num1, num2, result);
                break;
            case "*":
                num1 = getNum("Введи первое число:");
                num2 = getNum("Введи второе число:");
                result = num1 * num2;
                showResult(num1, num2, result);
                break;
            default:
                break;
        }
    }

}