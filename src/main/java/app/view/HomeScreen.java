package app.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HomeScreen {

    private JLayeredPane home;
    private JFrame app;
    private JTextField search;
    private JLabel map;
    private JButton articles[] = new JButton[5];

    public HomeScreen() throws IOException {
        app = new JFrame();

        URL url = new URL("https://media.wired.com/photos/653a575dacbe529f7b6d7872/191:100/w_1280,c_limit/rocket-biz-GettyImages-1740679014.jpg");
        BufferedImage image = ImageIO.read(url);

        home = new JLayeredPane();
        home.setLayout(new FlowLayout());

        search = new JTextField("Search", 120);
        home.add(search, JLayeredPane.DEFAULT_LAYER);


        JPanel btns = new JPanel(new GridLayout(1,5));
        for(int i = 0; i < 5; i++){

            articles[i] = new JButton();
            articles[i].setPreferredSize(new Dimension(290, 300));
            articles[i].setLayout(new BorderLayout());
            String s = "Rocket Alert Apps Warn Israelis of Incoming Attacks While Gaza Is Left in the Dark.\n" +
                    "Civilians in Israel can get mobile alerts of incoming rockets from apps that relay data from the Israel Defense Forces. Gaza has no early warning system, or internet access.\n" +
                    "2023-10-28T06:00:00Z\n" +
                    "Paresh Dave\n";
            JLabel article = new JLabel();
            article.setText("<html>" + s.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
            article.setIcon(new ImageIcon(image.getScaledInstance(100,100,Image.SCALE_SMOOTH)));
            article.setVerticalTextPosition(SwingConstants.TOP);
            article.setMaximumSize(new Dimension(290, 300));
            article.setPreferredSize(new Dimension(290, 300));
            article.setFont(new Font("Calibri",Font.PLAIN,14));
            articles[i].add(article, BorderLayout.CENTER);
            btns.add(articles[i]);

        }
        home.add(btns, JLayeredPane.DEFAULT_LAYER);

        map = new JLabel(new ImageIcon("/Users/saketrane/IdeaProjects/RoughGUI_press/src/map.png"));
        home.add(map, JLayeredPane.DEFAULT_LAYER);


        app.add(home);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setTitle("press");
        app.pack();
        app.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new HomeScreen();

    }
}