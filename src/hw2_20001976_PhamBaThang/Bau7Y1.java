package hw2_20001976_PhamBaThang;

import java.util.Random;
import java.util.Scanner;

public class Bau7Y1 {
    static int counter;
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int quantity = inputNumber(input, "so luong");
        int max = inputNumber(input, "so lon nhat");
        int[] numbers = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            if (i == 0)
                numbers[i] = random.nextInt(max + 1);
            else
                numbers[i] = noDup(numbers, random, i, max);
        }
        System.out.println("Array: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println("So lan random:" + counter);
    }

    public static int noDup(int[] numbers, Random random, int i, int max) {
        counter++;
        int newNum = random.nextInt(max + 1);
        for (int j = 0; j < i; j++) {
            if (numbers[j] == newNum)
                newNum = noDup(numbers, random, i, max);
        }
        return newNum;
    }

    public static int inputNumber(Scanner input, String name) {
        int number = 0;
        boolean check = false;
        while (!check) {
            System.out.print("Input " + name + ":");
            try {
                number = Integer.parseInt(input.nextLine());
                if (number > 0) {
                    check = true;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return number;
    }
}
