package ua.hillel.homeworks.hw5;

public class ServePokerDeck {
    public int numOfPlayers;

    public ServePokerDeck(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public void run() {
        if (numOfPlayers > 10) {
            throw new WrongNumberPlayers(" <= 10 players");
        }

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
