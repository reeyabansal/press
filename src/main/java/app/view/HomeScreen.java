package app.view;

import interface_adapters.Map.MapViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeScreen {

    private JPanel home;
    private JFrame app;
    private JTextField search;
    private JPanel map;
    private JButton articles[];
    private List<List<String>> info; //example data set pulled from API
    private String keyword;

    public HomeScreen() throws IOException {

        info = new MapViewModel().getState().getArticles();


        articles = new JButton[info.size()]; //making as many buttons as there are articles

        app = new JFrame();

        home = new JPanel();
        home.setLayout(new FlowLayout());

        search = new JTextField("Search", 120);
        home.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyword = search.getText();
            }
        });


        JPanel btns = new JPanel();
        for(int i = 0; i < articles.length; i++){

            articles[i] = new JButton();
            articles[i].setPreferredSize(new Dimension(290, 245));
            articles[i].setLayout(new BorderLayout());

            ArrayList<String> u = new ArrayList<String>(info.get(i));
            String Title = u.get(0);
            String ImageURL = u.get(1);
            String Description = u.get(2);
            String url = u.get(3);
            String PublishedAt = u.get(4);
            String Author = u.get(5);
            String text = "\n" + Description + "\n" + PublishedAt + "\n" + Author;
            BufferedImage image = ImageIO.read(new URL(ImageURL));

            JLabel article = new JLabel();
            article.setText("<html>" + "<b>"+ Title +"</b>" + text.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
            article.setIcon(new ImageIcon(image.getScaledInstance(100,100,Image.SCALE_SMOOTH)));
            article.setVerticalTextPosition(SwingConstants.TOP);
            article.setMaximumSize(new Dimension(290, 300));
            article.setPreferredSize(new Dimension(290, 300));
            article.setFont(new Font("Calibri",Font.PLAIN,13));
            articles[i].add(article);
            this.makeClick(url, articles[i]);
            btns.add(articles[i]);
        }
        home.add(btns);

        map = new JPanel();
        map.setPreferredSize(new Dimension(1200, 800));
        JLabel imgLabel = new JLabel(new ImageIcon("/Users/saketrane/IdeaProjects/RoughGUI_press/src/map.png"));
        imgLabel.setPreferredSize(new Dimension(1200, 500));

        JButton bCA = new JButton("CA");
        bCA.setSize(30,30);
        bCA.setLocation(250, 120);

        JButton bUS = new JButton("US");
        bUS.setSize(30,30);
        bUS.setLocation(259, 185);

        JButton bRU = new JButton("RU");
        bRU.setSize(30,30);
        bRU.setLocation(833, 110);

        JButton bAUS = new JButton("AUS");
        bAUS.setSize(30,30);
        bAUS.setLocation(935, 380);

        JButton bBR = new JButton("BR");
        bBR.setSize(30,30);
        bBR.setLocation(406, 340);

        JButton bIND = new JButton("IND");
        bIND.setSize(30,30);
        bIND.setLocation(780, 250);

        JButton bCHN = new JButton("CN");
        bCHN.setSize(30,30);
        bCHN.setLocation(848, 205);


        imgLabel.add(bCA);
        imgLabel.add(bUS);
        imgLabel.add(bRU);
        imgLabel.add(bAUS);
        imgLabel.add(bBR);
        imgLabel.add(bIND);
        imgLabel.add(bCHN);
        map.add(imgLabel);
        home.add(map);

        this.makeCountryClick(bCA, "Canada");
        this.makeCountryClick(bUS, "United States");
        this.makeCountryClick(bRU, "Russia");
        this.makeCountryClick(bAUS, "Australia");
        this.makeCountryClick(bBR, "Brazil");
        this.makeCountryClick(bIND, "India");
        this.makeCountryClick(bCHN, "China");

        app.add(home);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setTitle("press");
        app.pack();
        app.setVisible(true);

    }

    public void makeClick(String urlString, JButton button){

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Desktop.getDesktop().browse(new URL(urlString).toURI());
                } catch (IOException | URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public void makeCountryClick(JButton button, String country){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyword = country;
            }
        });
    }

    public static void main(String[] args) throws IOException {
        new HomeScreen();

    }
}