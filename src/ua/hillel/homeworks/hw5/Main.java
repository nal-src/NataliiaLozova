package ua.hillel.homeworks.hw5;

public class Main {
    public static void main(String[] args) {
        ServePokerDeck poker = new ServePokerDeck(10);
        try {
            poker.run();
        } catch(WrongNumberPlayers e) {
            System.out.println("Max players should be 10");
        }
    }
}
