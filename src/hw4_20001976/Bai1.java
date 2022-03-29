package hw4_20001976;

import java.util.Stack;

public class Bai1 {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        String hoten = "phambathang";
        for (int i = 0; i < hoten.length(); i++) {
            if (i % 2 == 0) {
                s.push(hoten.charAt(i));
            }
            if (i % 3 == 0) {
                s.pop();
            }
        }
        for (Character c : s
        ) {
            System.out.print(c + " "); // b g
        }
    }
}
