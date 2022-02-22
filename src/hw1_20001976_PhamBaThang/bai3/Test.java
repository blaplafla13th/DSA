package hw1_20001976_PhamBaThang.bai3;

import hw1_20001976_PhamBaThang.Bai2;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = Bai2.inputNumber(input, "numerator");
        int den = Bai2.inputNumber(input, "denominator");
        Fraction fraction = new Fraction(num, den);
        System.out.println(fraction);
        System.out.println("Test Plus:3/4");
        fraction.plus(new Fraction(3,4));
        System.out.println(fraction);
        System.out.println("Test multiple plus:3/4,2");
        fraction.plus(new Fraction(3,4),new Fraction(2));
        System.out.println(fraction);
        System.out.println("Test Subtract: 3/4");
        fraction.subtract(new Fraction(3,4));
        System.out.println(fraction);
        System.out.println("Test multiple subtract:3/4,2");
        fraction.subtract(new Fraction(3,4),new Fraction(2));
        System.out.println(fraction);
        System.out.println("Test multi:3/4");
        fraction.multi(new Fraction(3, 4));
        System.out.println(fraction);
        System.out.println("Test multiple multi:3/4,2");
        fraction.multi(new Fraction(3, 4), new Fraction(2));
        System.out.println(fraction);
        System.out.println("Test divide: 3/4,2");
        fraction.divide(new Fraction(3, 4));
        System.out.println(fraction);
        System.out.println("Test multiple divide:3/4,2");
        fraction.divide(new Fraction(3, 4), new Fraction(2));
        System.out.println(fraction);

    }
}
