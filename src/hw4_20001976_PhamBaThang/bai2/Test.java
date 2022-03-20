package hw4_20001976_PhamBaThang.bai2;

public class Test {
    public static void main(String[] args) {
        StackInterface<Integer> arrayStack = new ArrayStack<>();
        arrayStack.push(1);
        arrayStack.top();
        arrayStack.pop();
        arrayStack.push(1);
        arrayStack.push(1);
        for (Integer i : arrayStack) {
            System.out.println(i);
        }
        arrayStack = new LinkedListStack<>();
        arrayStack.push(1);
        arrayStack.top();
        arrayStack.pop();
        arrayStack.push(1);
        arrayStack.push(1);
        for (Integer i : arrayStack) {
            System.out.println(i);
        }
    }
}
