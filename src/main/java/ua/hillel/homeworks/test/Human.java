package ua.hillel.homeworks.test;

public class Human {
    int weight;
    int height;
    String color;

    public Human(int weight, int height, String color) {
        this.weight = weight;
        this.height = height;
        this.color = color;
    }

    public String getIngo() {
        return String.format("weight - %d, height - %d, color - %s", weight, height, color);
    }
}