package ua.hillel.homeworks.hw6;

public class FinCalculator extends Calculator {
    @Override
    protected String listOperations() {
        return "%sale, credit";
    }

    // %sale - сумму скидки по проценту скидки
    // credit - узнать ежемесяцную сумму по кредиту

    @Override
    protected void calculateResult() {
        double result;
        switch (operation) {
            case "%sale":
                float num1 = getNum("Введи сумму:");
                float num2 = getNum("Введи процент скидки:");
                result = num1 * num2 / 100;
                showResult(num1, num2, result);
                break;
            case "credit":
                float creditSum = getNum("Введи сумму кредита:");
                float creditMonth = getNum("Введи количество месяцев кредита:");
                float yearPercent = getNum("Введи годовую процентную ставку:");
                float p = yearPercent / 100 / 12;
                result = creditSum * (p  + (p / (Math.pow(1 + p, creditMonth) - 1) ));
                showResult(creditSum, creditMonth, result);
                break;
            default:
                break;
        }
    }
}


