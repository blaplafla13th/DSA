package hw6_20001976;

import hw6_20001976.card.Card;
import hw6_20001976.card.CardUtil;
import hw6_20001976.comparable_sort.*;

public class Bai3 {
    public static void main(String[] args) {
        Sort<Card> s;
        Card[] sortedArrayAsc = CardUtil.getPokerSet();
        Card[] unsortedArray = CardUtil.getPokerSet();
        CardUtil.shuffle(unsortedArray);
        System.out.println("Random Case:");
        s = new BubbleSort<>(unsortedArray.clone());
        s.calcTimeSortAsc();
        System.out.println(s);
        s = new InsertionSort<>(unsortedArray.clone());
        s.calcTimeSortAsc();
        System.out.println(s);
        s = new SelectionSort<>(unsortedArray.clone());
        s.calcTimeSortAsc();
        System.out.println(s);
        s = new HeapSort<>(unsortedArray.clone());
        s.calcTimeSortAsc();
        System.out.println(s);
        System.out.println("Best Case:");
        s = new BubbleSort<>(sortedArrayAsc.clone());
        s.calcTimeSortAsc();
        System.out.println(s);
        s = new InsertionSort<>(sortedArrayAsc.clone());
        s.calcTimeSortAsc();
        System.out.println(s);
        s = new SelectionSort<>(sortedArrayAsc.clone());
        s.calcTimeSortAsc();
        System.out.println(s);
        s = new HeapSort<>(sortedArrayAsc.clone());
        s.calcTimeSortAsc();
        System.out.println(s);
        System.out.println("Worst Case:");
        s = new BubbleSort<>(sortedArrayAsc.clone());
        s.calcTimeSortDesc();
        System.out.println(s);
        s = new InsertionSort<>(sortedArrayAsc.clone());
        s.calcTimeSortDesc();
        System.out.println(s);
        s = new SelectionSort<>(sortedArrayAsc.clone());
        s.calcTimeSortDesc();
        System.out.println(s);
        s = new HeapSort<>(sortedArrayAsc.clone());
        s.calcTimeSortDesc();
        System.out.println(s);
    }
}
