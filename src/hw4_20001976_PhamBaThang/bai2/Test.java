package hw4_20001976_PhamBaThang.bai2;

public class Test {
    public static void main(String[] args) {
        StackInterface<Integer> arrayStack = new ArrayStack<>();
        arrayStack.push(1);
        arrayStack.top();
        arrayStack.pop();
        System.out.println(arrayStack.isEmpty());
        arrayStack.push(1);
        arrayStack.push(1);
        for (Integer i : arrayStack) {
            System.out.println(i);
        }
        StackInterface<Integer> linkedListStack = new LinkedListStack<>();
        linkedListStack.push(1);
        linkedListStack.top();
        linkedListStack.pop();
        System.out.println(linkedListStack.isEmpty());
        linkedListStack.push(1);
        linkedListStack.push(1);
        for (Integer i : linkedListStack) {
            System.out.println(i);
        }
    }
}
