package hw4_20001976_PhamBaThang;

import hw4_20001976_PhamBaThang.bai3.LinkedListQueue;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedListQueue<Character> stringQueue = new LinkedListQueue<>();
        System.out.print("Input String: ");
        String inString = input.nextLine();
        int i = 0;
        for (; i <= inString.length() / 2; i++) {
            stringQueue.enqueue(inString.charAt(i));
        }
        if (inString.length() % 2 == 1) i++;
        for (; i < inString.length(); i++) {
            if (inString.charAt(i) != stringQueue.dequeue()) {
                System.out.println("Not Palindrome");
                return;
            }
        }
        System.out.println("Is Palindrome");
    }
}
