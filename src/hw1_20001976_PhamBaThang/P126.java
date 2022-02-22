package hw1_20001976_PhamBaThang;

import java.util.Scanner;

public class P126 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = Bai2.inputNumber(input, "line number");
        System.out.println("Input paragraph:");
        String[] paragraph = new String[length];
        for (int i = 0; i < length; i++) {
            System.out.print((i + 1) + ": ");
            paragraph[i] = input.nextLine();
        }
        System.out.println("Reserve order");
        for (int i = length - 1; i >= 0; i--) {
            System.out.println(paragraph[i]);
        }
    }
}
