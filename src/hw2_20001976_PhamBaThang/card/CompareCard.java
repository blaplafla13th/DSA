package hw2_20001976_PhamBaThang.card;

import java.util.Comparator;

public class CompareCard implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        return card1.compareTo(card2);
    }
}
