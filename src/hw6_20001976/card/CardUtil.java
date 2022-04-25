package hw6_20001976.card;

import java.util.ArrayList;
import java.util.Random;

public class CardUtil {
    public static Card[] getPokerSet() {
        ArrayList<Card> cards = new ArrayList<>(52);
        for (String rank : Card.RANKS) {
            for (String suit : Card.SUITS) {
                cards.add(new Card(suit, rank));
            }
        }
        return cards.toArray(new Card[cards.size()]);
    }

    public static void shuffle(Card[] cards) {
        if (cards == null) {
            System.out.println("null");
            System.exit(0);
        }
        Random random = new Random();
        for (int i = cards.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            swap(cards, i, index);
        }
    }

    public static void swap(Card[] cards, int indexA, int indexB) {
        if (cards == null) {
            System.out.println("null");
            System.exit(0);
        }
        if (indexA == indexB) return;
        Card temp = cards[indexA];
        cards[indexA] = cards[indexB];
        cards[indexB] = temp;
    }
}
