package hw2_20001976_PhamBaThang.card;

import java.util.Arrays;
import java.util.InputMismatchException;

public class Card implements Comparable<Card> {
    public static final String[] RANKS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    public static final String[] SUITS = {"♠", "♣", "♦", "♥"};
    private String rank;
    private String suit;

    public Card(String suit, String rank) {
        if (Arrays.asList(RANKS).contains(rank) && Arrays.asList(SUITS).contains(suit)) {
            this.rank = rank;
            this.suit = suit;
        } else {
            throw new InputMismatchException();
        }
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        if (Arrays.asList(RANKS).contains(rank))
            this.rank = rank;
        else
            throw new InputMismatchException();
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        if (Arrays.asList(SUITS).contains(suit))
            this.suit = suit;
        else
            throw new InputMismatchException();
    }


    @Override
    public int compareTo(Card card) {
        if (card == null) throw new IllegalArgumentException();
        if (Arrays.asList(SUITS).indexOf(this.suit) > Arrays.asList(SUITS).indexOf(card.suit))
            return 1;
        else if (Arrays.asList(SUITS).indexOf(this.suit) < Arrays.asList(SUITS).indexOf(card.suit))
            return -1;
        else return Integer.compare(Arrays.asList(RANKS).indexOf(this.rank), Arrays.asList(RANKS).indexOf(card.rank));
    }

    @Override
    public String toString() {
        return "|" + suit + rank + '|';
    }
}
