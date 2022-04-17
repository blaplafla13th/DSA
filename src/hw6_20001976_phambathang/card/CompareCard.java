package hw6_20001976_phambathang.card;

import java.util.Comparator;

public class CompareCard implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        return card1.compareTo(card2);
    }
}
