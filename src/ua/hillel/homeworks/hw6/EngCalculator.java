package ua.hillel.homeworks.hw6;

public class EngCalculator extends SimpleCalculator {
    @Override
    protected String listOperations() {
        String parentOperations = super.listOperations();
        return parentOperations + ", sin, cos, tan, ^";
    }

    @Override
    protected void calculateResult() {
        super.calculateResult();

        float num1;
        float num2;
        double numRad;
        double result;
        switch (operation) {
            case "sin":
                num1 = getNum("Введи число:");
                numRad = Math.toRadians(num1);
                result = Math.sin(numRad);
                showResult(num1, result);
                break;
            case "cos":
                num1 = getNum("Введи число:");
                numRad = Math.toRadians(num1);
                result = Math.cos(numRad);
                showResult(num1, result);
                break;
            case "tan":
                num1 = getNum("Введи число:");
                numRad = Math.toRadians(num1);
                result = Math.tan(numRad);
                showResult(num1, result);
                break;
            case "^":
                num1 = getNum("Введи число:");
                num2 = getNum("Введи степень:");
                result = Math.pow(num1, num2);
                showResult(num1, num2, result);
                break;
            default:
                break;
        }
    }

}
