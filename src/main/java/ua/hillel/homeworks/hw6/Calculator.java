package ua.hillel.homeworks.hw6;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

abstract public class Calculator {
    protected Scanner scanner = new Scanner(System.in);
    protected String operation;

    abstract protected String listOperations();
    abstract protected void calculateResult();

    public void run() {
        showOperation();
        System.out.println("Введи нужную операцию:");
        operation = scanner.nextLine();
        if (validatedOperation()) {
            calculateResult();
        } else {
            System.out.println("Введенного типа операции не существует в калькуляторе");
        }
    }

    public boolean validatedOperation() {
        String allOperations = listOperations();
        String[] validOperations = allOperations.split(", ");
        boolean isPresentOperation = false;
        for(String validOperation: validOperations) {
            if (validOperation.equals(operation)) {
                isPresentOperation = true;
            }
        }
        return isPresentOperation;
    }

    protected void showOperation() {
        System.out.println("\n");
        System.out.println("Типы операций: " + listOperations());
    }

    protected float getNum(String text) {
        System.out.println(text);
        return Float.parseFloat(scanner.nextLine());
    }

    protected void showResult(float num, double result) {
        System.out.printf("Результат операции %s %f = %f", operation, num, result);
        System.exit(0);
    }

    protected void showResult(float num1, float num2, double result) {
        System.out.printf("Результат операции %f %s %f = %f", num1, operation, num2, result);
        System.exit(0);
    }
}
