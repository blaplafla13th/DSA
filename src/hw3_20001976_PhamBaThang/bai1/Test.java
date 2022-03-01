package hw3_20001976_PhamBaThang.bai1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //y1
        int quantity = inputQuantity(input, "so luong");
        Fraction[] fractions = new Fraction[quantity];
        for (int i = 0; i < quantity; i++) {
            float num = inputNumber(input, "numerator " + (i + 1));
            float den = inputNumber(input, "denominator " + (i + 1));
            fractions[i] = new Fraction(num, den);
        }
        System.out.println("List các phân số: ");
        for (Fraction fraction : fractions) {
            System.out.println(fraction + " ");
        }
        //y2
        int index = inputIndex(input, "index of fraction", quantity);
        System.out.println("Phần tử thứ " + index + " là " + fractions[index]);
        //y3
        System.out.println("Tổng các phần tử trong mảng là: " + new Fraction(0).add(fractions));
        //y4
        float number = inputNumber(input, "number to convert it to fraction");
        System.out.println(new Fraction(number));
    }

    public static int inputQuantity(Scanner input, String name) {
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

    public static int inputIndex(Scanner input, String name, int max) {
        int number = 0;
        boolean check = false;
        while (!check) {
            System.out.print("Input " + name + ":");
            try {
                number = Integer.parseInt(input.nextLine());
                if (number < 0) {
                    throw new IndexOutOfBoundsException("Index phan tu phai lon hon 0");
                } else if (number >= max)
                    throw new IndexOutOfBoundsException("Index phan tu phai nho hon " + max);
                else check = true;
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                System.out.println(e);
            }
        }
        return number;
    }

    public static float inputNumber(Scanner input, String name) {
        float number = 0;
        boolean check = false;
        while (!check) {
            System.out.print("Input " + name + ":");
            try {
                number = Float.parseFloat(input.nextLine());
                if (name.contains("denominator") && number == 0) {
                    throw new NumberFormatException("Mau phai khac 0");
                } else check = true;
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
        return number;
    }
}


