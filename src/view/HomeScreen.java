package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class HomeScreen {

    private JPanel home;
    private JFrame app;
    private JTextField search;
    private JLabel map;
    private JButton articles[] = new JButton[5];

    public HomeScreen() throws IOException {
        app = new JFrame();


        home = new JPanel();

        search = new JTextField("Search", 120);
        home.add(search);
        for(int i = 0; i < 5; i++){
            URL url = new URL("https://fastly.picsum.photos/id/0/5000/3333.jpg?hmac=_j6ghY5fCfSD6tvtcV74zXivkJSPIfR9B8w34XeQmvU");
            BufferedImage image = ImageIO.read(url);
            articles[i] = new JButton( new ImageIcon(image.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
            articles[i].setPreferredSize(new Dimension(250, 300));
            home.add(articles[i]);
        }
        map = new JLabel(new ImageIcon("/Users/saketrane/IdeaProjects/RoughGUI_press/src/map.png"));
        home.add(map);


        app.add(home);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setTitle("press project");
        app.pack();
        app.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new HomeScreen();

    }
}
