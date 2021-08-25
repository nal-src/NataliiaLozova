package ua.hillel.homeworks.test;

public class Main {
    public static void main(String[] args) {
        String type = "Платья";
        int number = 5;
        int time = 6;
        System.out.printf("Купил %s в количестве %d штук и вышла в нем гулять в %d вечера", type, number, time);
        System.out.println("\n");
        System.out.println("Купил " + type + "в количестве" + number + " штук и вышла в нем гулять в " + time + " вечера");

        Human h = new Human(10, 52, "white");
        System.out.println(h.getIngo());
    }
}


