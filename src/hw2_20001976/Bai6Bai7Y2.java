package hw2_20001976;

import hw2_20001976.card.Card;
import hw2_20001976.comparable_sort.BubbleSort;
import hw2_20001976.comparable_sort.InsertionSort;
import hw2_20001976.comparable_sort.SelectionSort;
import hw2_20001976.comparable_sort.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Bai6Bai7Y2 {
    public static void main(String[] args) {
        ArrayList<Card> cards = new ArrayList<>(52);
        for (String suit : Card.SUITS) {
            for (String rank : Card.RANKS) {
                cards.add(new Card(suit, rank));
            }
        }
        Card[] pokerSet = new Card[52];
        pokerSet = cards.toArray(pokerSet);
        printCards(pokerSet);
        //bai7 y 2
        shuffle(pokerSet);
        printCards(pokerSet);
        //bai 6 y 1
        System.out.println("Arrays.sort:");
        Arrays.sort(pokerSet);
        printCards(pokerSet);

        shuffle(pokerSet);
        printCards(pokerSet);
        System.out.println("Bubble sort:");
        Sort<Card> bubbleSort = new BubbleSort<>(pokerSet.clone());
        bubbleSort.sortAsc(false);
        bubbleSort.printArray();
        // bai2
        System.out.println("Selection sort:");
        Sort<Card> selectionSort = new SelectionSort<>(pokerSet.clone());
        selectionSort.sortAsc(false);
        selectionSort.printArray();
        // bai3
        System.out.println("Insertion sort:");
        Sort<Card> insertionSort = new InsertionSort<>(pokerSet.clone());
        insertionSort.sortAsc(false);
        insertionSort.printArray();
    }

    public static void printCards(Card[] cards) {
        if (cards == null) {
            System.out.println("null");
            System.exit(0);
        }
        for (Card card : cards) {
            System.out.print(card + " ");
        }
        System.out.println();
    }

    public static void shuffle(Card[] cards) {
        System.out.println("Shuffle card:");
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
