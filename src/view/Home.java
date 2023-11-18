package view;

import javax.swing.*;

public class Home {

    private JPanel panel1;
    private JLabel WorldMap;

    private void createUIComponents() {
        // Ensure that the image file is in the correct location or provide an absolute path
        WorldMap = new JLabel(new ImageIcon("/Users/saketrane/IdeaProjects/press/src/view/map.png"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainframe = new JFrame("Home");
            mainframe.setContentPane(new Home().panel1);
            mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainframe.setSize(600, 400);
            mainframe.setVisible(true);
        });
    }
}
