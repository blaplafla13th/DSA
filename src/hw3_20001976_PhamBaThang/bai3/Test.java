package hw3_20001976_PhamBaThang.bai3;

public class Test {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.add(0);
        simpleLinkedList.add(3);
        simpleLinkedList.addBot(9);
        simpleLinkedList.add(1);
        simpleLinkedList.addBot(5);
        simpleLinkedList.add(8);
        simpleLinkedList.add(4);

        System.out.println("Check add:");
        for (int i = 0; i < simpleLinkedList.size(); i++) {
            System.out.print(simpleLinkedList.get(i) + " ");
        }
        System.out.println();
        System.out.println("Check set and contain:");
        simpleLinkedList.set(2, 2);
        System.out.println("Is it containing 2:" + simpleLinkedList.isContain(2));
        for (int i = 0; i < simpleLinkedList.size(); i++) {
            System.out.print(simpleLinkedList.get(i) + " ");
        }
        System.out.println();
        System.out.println("Check remove top:");
        simpleLinkedList.removeTop();
        for (int i = 0; i < simpleLinkedList.size(); i++) {
            System.out.println(simpleLinkedList.get(i));
        }
        System.out.println();
        System.out.println("Check remove bot:");
        simpleLinkedList.removeBot();
        for (int i = 0; i < simpleLinkedList.size(); i++) {
            System.out.println(simpleLinkedList.get(i));
        }
        System.out.println();
        System.out.println("Check remove data:");
        simpleLinkedList.add(2);
        simpleLinkedList.addBot(2);
        simpleLinkedList.remove(2);
        for (int i = 0; i < simpleLinkedList.size(); i++) {
            System.out.println(simpleLinkedList.get(i));
        }
    }
}
