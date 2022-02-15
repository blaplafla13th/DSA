package hw1_20001976.bai3;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator != 0) {
            this.numerator = numerator;
            this.denominator = denominator;
        } else
            throw new NumberFormatException("Divide zero");
        simplifyFraction();
    }

    public Fraction(int number) {
        this.numerator = number;
        denominator = 1;
    }

    public void simplifyFraction() {
        int gcdVal = gcd(this.numerator, this.denominator);
        numerator /= gcdVal;
        denominator /= gcdVal;
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
    }

    public static int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

    @Override
    public String toString() {
        simplifyFraction();
        if (denominator != 1)
            return numerator + "/" + denominator;
        else
            return numerator + "";
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public void plus(Fraction fraction) {
        numerator = this.numerator * fraction.denominator + this.denominator * fraction.numerator;
        denominator = this.denominator * fraction.denominator;
    }

    public void subtract(Fraction fraction) {
        numerator = this.numerator * fraction.denominator - this.denominator * fraction.numerator;
        denominator = this.denominator * fraction.denominator;
    }

    public void multi(Fraction fraction) {
        numerator = this.numerator * fraction.numerator;
        denominator = this.denominator * fraction.denominator;
    }

    public void divide(Fraction fraction) {
        if (fraction.numerator == 0) {
            throw new ArithmeticException("Divide by zero");
        }
        numerator = this.numerator * fraction.denominator;
        denominator = this.denominator * fraction.numerator;
    }
    public void plus(Fraction... fractions){
        for (Fraction fraction: fractions) {
            this.plus(fraction);
        }
    }public void subtract(Fraction... fractions){
        for (Fraction fraction: fractions) {
            this.subtract(fraction);
        }
    }public void multi(Fraction... fractions){
        for (Fraction fraction: fractions) {
            this.multi(fraction);
        }
    }public void divide(Fraction... fractions){
        for (Fraction fraction: fractions) {
            this.divide(fraction);
        }
    }
}
