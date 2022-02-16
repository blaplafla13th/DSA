package hw1_20001976;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Input Boolean:");
            boolean bool = Boolean.parseBoolean(input.nextLine());
            System.out.println("Value you input:" + bool);
        } catch (Exception e) {
            System.out.println("Not a boolean");
        }
        try {
            System.out.print("Input Byte:");
            byte by = Byte.parseByte(input.nextLine());
            System.out.println("Value you input:" + by);
        } catch (Exception e) {
            System.out.println("Not a byte");
        }
        try {
            System.out.print("Input Char:");
            char c = input.nextLine().charAt(0);
            System.out.println("Value you input:" + c);
        } catch (Exception e) {
            System.out.println("Not a character");
        }
        try {
            System.out.print("Input Double:");
            double d = Double.parseDouble(input.nextLine());
            System.out.println("Value you input:" + d);
        } catch (Exception e) {
            System.out.println("Not a double");
        }
        try {
            System.out.print("Input Float:");
            float f = Float.parseFloat(input.nextLine());
            System.out.println("Value you input:" + f);
        } catch (Exception e) {
            System.out.println("Not a float");
        }
        try {
            System.out.print("Input Integer:");
            int i = Integer.parseInt(input.nextLine());
            System.out.println("Value you input:" + i);
        } catch (Exception e) {
            System.out.println("Not a Integer");
        }
        try {
            System.out.print("Input Long:");
            long l = Long.parseLong(input.nextLine());
            System.out.println("Value you input:" + l);
        } catch (Exception e) {
            System.out.println("Not a long");
        }
        try {
            System.out.print("Input Short:");
            short s = Short.parseShort(input.nextLine());
            System.out.println("Value you input:" + s);
        } catch (Exception e) {
            System.out.println("Not a short");
        }

    }
}
