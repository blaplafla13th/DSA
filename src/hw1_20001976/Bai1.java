package hw1_20001976;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            boolean bool = input.nextBoolean();
            System.out.println(bool);
        } catch (Exception e) {
            System.out.println("Not a boolean");
        }
        try {
            byte by = input.nextByte();
            System.out.println(by);
        } catch (Exception e) {
            System.out.println("Not a byte");
        }
        try {
            char c = input.nextLine().charAt(0);
            System.out.println(c);
        } catch (Exception e) {
            System.out.println("Not a character");
        }
        try {
            double d = input.nextDouble();
            System.out.println(d);
        } catch (Exception e) {
            System.out.println("Not a double");
        }
        try {
            float f = input.nextFloat();
            System.out.println(f);
        } catch (Exception e) {
            System.out.println("Not a float");
        }
        try {
            int i = input.nextInt();
            System.out.println(i);
        } catch (Exception e) {
            System.out.println("Not a Integer");
        }
        try {
            long l = input.nextLong();
            System.out.println(l);
        } catch (Exception e) {
            System.out.println("Not a long");
        }
        try {
            short s = input.nextShort();
            System.out.println(s);
        } catch (Exception e) {
            System.out.println("Not a short");
        }

    }
}
