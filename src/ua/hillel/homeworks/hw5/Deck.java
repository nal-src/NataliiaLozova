package ua.hillel.homeworks.hw5;

import java.util.Random;

public class Deck {
    private final String[] cardValues = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private final String[] cardSuits = {"Hearts", "Clubs", "Diamonds", "Spades"};
    private static final int numOfCards = 52;
    private static final Card[] cards =  new Card[numOfCards];

    public Deck() {
        create();
    }

    public Card[] getCards() {
        return cards;
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int in = random.nextInt(numOfCards);
            int out = random.nextInt(numOfCards);
            Card card = cards[in];
            cards[in] = cards[out];
            cards[out] = card;
        }
    }

    private void create() {
        int count = 0;
        for (String suit: cardSuits) {
            for (String value: cardValues) {
                cards[count++] = new Card(suit, value);
            }
        }
    }
}
