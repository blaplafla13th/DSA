package hw4_20001976_PhamBaThang.bai6.maze;

public class Maze {
    public static void main(String[] args) {
        try {
            Class.forName("com.intellij.uiDesigner.core.GridConstraints");
            InputSizePanel start = new InputSizePanel();
            start.pack();
            start.setVisible(true);
        } catch (Exception e) {
            System.out.println("Use Intellij IDEA to run this code. If you are running on Intellij IDEA, try delete out folder");
        }
    }
}
