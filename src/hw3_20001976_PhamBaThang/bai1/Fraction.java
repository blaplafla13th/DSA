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
        normalize();
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
        // anti lech phay dong
        String num = Float.valueOf(numerator).toString();
        String den = Float.valueOf(denominator).toString();
        int number;
        if (num.contains(".") || den.contains(".")) {
            number = Math.max(num.length() - num.indexOf("."), den.length() - den.indexOf("."));
            numerator = Math.round(numerator * Math.pow(10, number));
            denominator = Math.round(denominator * Math.pow(10, number));
        }

        // lech phay dong
//        while (this.numerator != Math.floor(this.numerator) || this.denominator != Math.floor(this.denominator)) {
//            numerator*=10;
//            denominator*=10;
//        }
        float gcdVal = gcd(this.numerator, this.denominator);
        this.numerator /= gcdVal;
        this.denominator /= gcdVal;
        if (this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }
    }

    public Fraction normalize(Fraction c) {
        // anti lech phay dong
        String num = Float.valueOf(c.numerator).toString();
        String den = Float.valueOf(c.denominator).toString();
        int number;
        if (num.contains(".") || den.contains(".")) {
            number = Math.max(num.length() - num.indexOf("."), den.length() - den.indexOf("."));
            c.numerator = Math.round(c.numerator * Math.pow(10, number));
            c.denominator = Math.round(c.denominator * Math.pow(10, number));
        }

        // lech phay dong
//        while (this.numerator != Math.floor(this.numerator) || this.denominator != Math.floor(this.denominator)) {
//            numerator*=10;
//            denominator*=10;
//        }
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

    public void setNumerator(float numerator) {
        if (numerator == 0) throw new NumberFormatException("Divide zero");
        this.numerator = numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    public void setDenominator(float denominator) {
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
