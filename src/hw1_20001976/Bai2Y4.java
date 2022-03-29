package hw1_20001976;

public class Bai2Y4<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Bai2Y4{" +
                "value=" + value +
                '}';
    }

    public void isPerfect() {
        try {
            int value = ((Number) this.value).intValue();
            if (value == 0) {
                throw null;
            }
            int sum = 0;
            for (int i = 1; i < value; i++) {
                if (value % i == 0) {
                    sum += i;
                }
            }
            if (sum == ((Number) this.value).doubleValue()) {
                System.out.println(this.value + " la so hoan hao");
                return;
            }
        } catch (Exception ignored) {
        }
        System.out.println(this.value + " khong phai so hoan hao");
    }
}

class Test {
    public static void main(String[] args) {
        Bai2Y4<Double>[] array = new Bai2Y4[6];
        double a = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = new Bai2Y4<Double>();
            array[i].setValue((double) a);
            a += 1.5;
        }
        for (Bai2Y4 i : array) {
            i.isPerfect();
        }
    }
}
