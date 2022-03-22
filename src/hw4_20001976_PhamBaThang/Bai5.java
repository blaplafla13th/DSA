package hw4_20001976_PhamBaThang;

import hw4_20001976_PhamBaThang.bai2.LinkedListStack;
import hw4_20001976_PhamBaThang.bai3.LinkedListQueue;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedListQueue<Character> stringQueue = new LinkedListQueue<>();
        LinkedListStack<Character> stringStack = new LinkedListStack<>();
        System.out.print("Input String: ");
        String inString = input.nextLine().trim().toLowerCase().replaceAll("[^0-9a-zA-Z]+", "");
        int mid = inString.length() % 2 == 0 ? inString.length() / 2 : inString.length() / 2 + 1;

        for (int i = 0; i <= mid; i++) {
            stringQueue.enqueue(inString.charAt(i));
        }
        for (int j = inString.length() - 1; j >= mid - 1; j--) {
            stringStack.push(inString.charAt(j));
        }
        while (!stringStack.isEmpty() && !stringQueue.isEmpty()) {
            if (stringStack.pop() != stringQueue.dequeue()) {
                System.out.println("Not Palindrome");
                return;
            }
        }
        System.out.println("Is Palindrome");
    }
}
