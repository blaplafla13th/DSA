package hw3_20001976.bai2;

public class Test {
    public static void main(String[] args) {
        ListInterface<String> list = new SimpleArrayList<>(1);
        System.out.println("Test add");
        list.add("Eren");
        list.add("Mikasa");
        System.out.println("Test for each");
        for (String item : list) {
            System.out.println(" - " + item);
        }
        System.out.println("Test set");
        list.set(0, "Jean");
        System.out.println("Test size:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(" - " + list.get(i));
        }
        System.out.println("Test remove: Jean");
        list.remove("Eren");
        list.remove("Jean");
        System.out.println("Test isContain:" + list.isContain("Jean"));
        System.out.println("Test isEmpty:" + list.isEmpty());
        try {
            System.out.print("Out of index test:");
            System.out.println(list.get(2));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println();
    }
}
