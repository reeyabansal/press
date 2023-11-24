package view;

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
    private List<List<String>> info = new ArrayList<>(); //example data set pulled from API
    private String searchText;

    public HomeScreen() throws IOException {
        //making the example data set
        ArrayList<String> f = new ArrayList<String>();
        String Title = "Rocket Alert Apps Warn Israelis of Incoming Attacks While Gaza Is Left in the Dark.";
        String ImageURL = "https://media.wired.com/photos/653a575dacbe529f7b6d7872/191:100/w_1280,c_limit/rocket-biz-GettyImages-1740679014.jpg";
        String Description = "Civilians in Israel can get mobile alerts of incoming rockets from apps that relay data from the Israel Defense Forces. Gaza has no early warning system, or internet access.";
        String URL = "https://www.wired.com/story/rocket-alert-apps-warn-israelis-attacks-gaza-left-in-the-dark/";
        String PublishedAt = "2023-10-28T06:00:00Z";
        String Author = "Paresh Dave";
        f.add(Title);
        f.add(ImageURL);
        f.add(Description);
        f.add(URL);
        f.add(PublishedAt);
        f.add(Author);
        info.add(f);
        ArrayList<String> f1 = new ArrayList<String>(f);
        ArrayList<String> f2 = new ArrayList<String>(f);
        ArrayList<String> f3 = new ArrayList<String>(f);
        ArrayList<String> f4 = new ArrayList<String>(f);
        ArrayList<String> f5 = new ArrayList<String>(f);
        ArrayList<String> f6 = new ArrayList<String>(f);
        info.add(f1);
        info.add(f2);
        info.add(f3);
        info.add(f4);
        info.add(f5);
        info.add(f6);

        articles = new JButton[info.size()];

        app = new JFrame();

        home = new JPanel();
        home.setLayout(new FlowLayout());

        search = new JTextField("Search", 120);
        home.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchText = search.getText();
                System.out.println(searchText);
            }
        });


        JPanel btns = new JPanel();
        for(int i = 0; i < articles.length; i++){

            articles[i] = new JButton();
            articles[i].setPreferredSize(new Dimension(290, 245));
            articles[i].setLayout(new BorderLayout());

            ArrayList<String> u = new ArrayList<String>(info.get(i));
            Title = u.get(0);
            ImageURL = u.get(1);
            Description = u.get(2);
            URL = u.get(3);
            PublishedAt = u.get(4);
            Author = u.get(5);
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
            this.makeClick(URL, articles[i]);
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

    public static void main(String[] args) throws IOException {
        new HomeScreen();

    }
}