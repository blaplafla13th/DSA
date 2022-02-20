package hw1_20001976;

public class Bai2Y4<N extends Number> {
    public final int length;
    private Number[] numberArray;

    public Bai2Y4(int length) {
        numberArray = new Number[length];
        this.length = length;
    }

    N get(int index) {
        @SuppressWarnings("not number") final N number = (N) numberArray[index];
        return number;
    }

    void add(int index, N number) {
        numberArray[index] = number;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println("Test");
        Bai2Y4 numberArray = new Bai2Y4(3);
        numberArray.add(0, 3);
        numberArray.add(1, 3.5f);
        numberArray.add(2, Math.PI);
        for (int i = 0; i < numberArray.length; i++) {
            System.out.println(numberArray.get(i));
        }
    }
}
