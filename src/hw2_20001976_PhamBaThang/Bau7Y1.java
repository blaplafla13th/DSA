package hw2_20001976_PhamBaThang;

import java.util.Random;
import java.util.Scanner;

public class Bau7Y1 {
    static long counter = 0;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int quantity = inputNumber(input, "so luong");
        int max = inputNumber(input, "so lon nhat");
        int[] numbers = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            numbers[i] = noDup(numbers, random, i, max);
        }
        System.out.println("Array: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println("So lan random:" + counter);
    }

    public static int noDup(int[] numbers, Random random, int i, int max) {
        int newNum = random.nextInt(max + 1);
        counter++;
        while (isDup(numbers, i, newNum)) {
            newNum = random.nextInt(max + 1);
            counter++;
        }
        return newNum;
    }

    public static boolean isDup(int[] numbers, int i, int newNum) {
        for (int j = 0; j < i; j++) {
            if (numbers[j] == newNum)
                return true;
        }
        return false;
    }


    public static int inputNumber(Scanner input, String name) {
        int number = 0;
        boolean check = false;
        while (!check) {
            System.out.print("Input " + name + ":");
            try {
                number = Integer.parseInt(input.nextLine());
                if (number <= 0) {
                    throw new NumberFormatException("So phai lon hon 0");
                } else check = true;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return number;
    }
}
