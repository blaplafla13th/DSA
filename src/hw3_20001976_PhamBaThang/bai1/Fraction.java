package hw3_20001976_PhamBaThang.bai1;

public class Fraction {
    private float numerator;
    private float denominator;

    public Fraction(float numerator, float denominator) {
        if (denominator != 0) {
            this.numerator = numerator;
            this.denominator = denominator;
        } else
            throw new NumberFormatException("Divide zero");
        normalize();
    }

    public Fraction(float number) {
        this.numerator = number;
        denominator = 1;
    }

    public static float gcd(float a, float b) {
        while (a != 0) {
            float temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

    public void normalize() {
        while (this.numerator != Math.floor(this.numerator) || this.denominator != Math.floor(this.denominator)) {
            this.numerator *= 10;
            this.denominator *= 10;
        }
        float gcdVal = gcd(this.numerator, this.denominator);
        this.numerator /= gcdVal;
        this.denominator /= gcdVal;
        if (this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }
    }

    public Fraction normalize(Fraction c) {
        while (c.numerator != Math.floor(c.numerator) && c.denominator != Math.floor(c.denominator)) {
            c.numerator *= 10;
            c.denominator *= 10;
        }
        float gcdVal = gcd(c.numerator, c.denominator);
        c.numerator /= gcdVal;
        c.denominator /= gcdVal;
        if (c.denominator < 0) {
            c.numerator *= -1;
            c.denominator *= -1;
        }
        return c;
    }

    @Override
    public String toString() {
        normalize();
        if (denominator != 1)
            return String.format("%.0f/%.0f", numerator, denominator);
        else
            return String.format("%.0f", numerator);
    }

    public float getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        if (numerator == 0) throw new NumberFormatException("Divide zero");
        this.numerator = numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public Fraction add(Fraction c) {
        if (c == null) {
            throw new IllegalArgumentException();
        }
        numerator = this.numerator * c.denominator + this.denominator * c.numerator;
        denominator = this.denominator * c.denominator;
        return this;
    }

    public Fraction minus(Fraction c) {
        if (c == null) {
            throw new IllegalArgumentException();
        }
        numerator = this.numerator * c.denominator - this.denominator * c.numerator;
        denominator = this.denominator * c.denominator;
        return this;
    }

    public Fraction multi(Fraction c) {
        if (c == null) {
            throw new IllegalArgumentException();
        }
        numerator = this.numerator * c.numerator;
        denominator = this.denominator * c.denominator;
        return this;
    }

    public Fraction divi(Fraction c) {
        if (c == null) {
            throw new IllegalArgumentException();
        }
        if (c.numerator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        numerator = this.numerator * c.denominator;
        denominator = this.denominator * c.numerator;
        return this;
    }

    public Fraction add(Fraction... fractions) {
        for (Fraction fraction : fractions) {
            this.add(fraction);
        }
        return this;
    }

    public Fraction minus(Fraction... fractions) {
        for (Fraction fraction : fractions) {
            this.minus(fraction);
        }
        return this;
    }

    public Fraction multi(Fraction... fractions) {
        for (Fraction fraction : fractions) {
            this.multi(fraction);
        }
        return this;
    }

    public Fraction divi(Fraction... fractions) {
        for (Fraction fraction : fractions) {
            this.divi(fraction);
        }
        return this;
    }
}
