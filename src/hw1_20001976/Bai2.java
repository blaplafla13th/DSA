package hw1_20001976;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = inputNumber(input, "n");
        int[] a = new int[n];
        //y 1
        for (int i = 0; i < n; i++) {
            a[i] = inputNumber(input, "number " + (i + 1));
        }
        //y 2
        findPerfect(a);
        //y 3
        findPrime(a);
    }

    public static void findPerfect(int[] a) {
        System.out.println("Perfect number in array: ");
        for (int i :
                a) {
            if (isPerfect(i))
                System.out.print(i + " ");
        }
        System.out.println();
    }

    public static boolean isPerfect(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

    public static void findPrime(int[] a) {
        System.out.println("Prime number in array: ");
        for (int i : a) {
            if (isPrime(i))
                System.out.print(i + " ");
        }
        System.out.println();
    }

    public static boolean isPrime(int number) {
        if (number < 2)
            return false;
        if (number == 2)
            return true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
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
