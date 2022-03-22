package hw4_20001976_PhamBaThang.bai6.tower;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame();
            mainFrame.setSize(1000, 280);
            mainFrame.setLocationRelativeTo(null);
            Tower towerOfHanoi = new Tower();
            mainFrame.getContentPane().add(towerOfHanoi);
            mainFrame.setVisible(true);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
