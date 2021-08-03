package ua.hillel.homeworks.hw5;

public class ServePokerDeck {
    public int numOfPlayers;

    public ServePokerDeck(int numOfPlayers) {
        if (numOfPlayers <= 10) {
            this.numOfPlayers = numOfPlayers;
        } else {
            System.out.println("Max players 10");
            System.exit(0);
        }
    }

    public void run() {
        Deck deck = new Deck();
        deck.shuffle();
        Card[] cards = deck.getCards();

        int count = 0;
        for (int round = 1; round < 6; round++ ) {
            System.out.println("Round " + round);
            for(int player = 1; player < numOfPlayers + 1; player++) {
                Card card = cards[count++];
                System.out.printf("Player %d gets card %s%n", player, card);
            }
            System.out.println("\n\n");
        }
    }
}
