package app.view;

import interface_adapters.Favourite.FavouriteController;
import interface_adapters.Favourite.FavouriteViewModel;
import interface_adapters.Map.MapController;
import interface_adapters.Map.MapState;
import interface_adapters.Map.MapViewModel;
import interface_adapters.Search.SearchController;
import interface_adapters.Search.SearchViewModel;
import interface_adapters.SeeFavourites.SeeFavouritesController;
import interface_adapters.SeeFavourites.SeeFavouritesViewModel;
import interface_adapters.TopNews.TopNewsController;
import interface_adapters.TopNews.TopNewsViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends JPanel implements ActionListener, PropertyChangeListener {

    private JPanel home;
    private JFrame app;
    private JTextField search;
    private JPanel map;
    private JPanel btns;
    private JButton articles[];
    private List<List<String>> info = new ArrayList<>(); //example data set pulled from API
    private String keyword;
    private int currPage;

    private MapController mapController;
    private TopNewsController topNewsController;
    private MapViewModel mapViewModel;

    private TopNewsViewModel topNewsViewModel;
    private SearchViewModel searchViewModel;
    private SearchController searchController;
    private FavouriteController favouriteController;
    private FavouriteViewModel favouriteViewModel;
    private SeeFavouritesController seeFavouritesController;
    private SeeFavouritesViewModel seeFavouritesViewModel;


    public HomeScreen(MapController mapController, TopNewsController topNewsController, SearchController searchController, FavouriteController favouriteController, SeeFavouritesController seeFavouritesController, MapViewModel mapViewModel, TopNewsViewModel topNewsViewModel, SearchViewModel searchViewModel, FavouriteViewModel favouriteViewModel, SeeFavouritesViewModel seeFavouritesViewModel) throws IOException, InterruptedException {
        this.topNewsController = topNewsController;
        this.topNewsViewModel = topNewsViewModel;
        this.searchController = searchController;
        this.searchViewModel = searchViewModel;
        this.mapController = mapController;
        this.mapViewModel = mapViewModel;
        this.favouriteController = favouriteController;
        this.favouriteViewModel = favouriteViewModel;
        this.seeFavouritesController = seeFavouritesController;
        this.seeFavouritesViewModel = seeFavouritesViewModel;
        this.topNewsViewModel.addPropertyChangeListener(this);
        this.searchViewModel.addPropertyChangeListener(this);
        this.mapViewModel.addPropertyChangeListener(this);

        topNewsController.execute();
        info = this.topNewsViewModel.getState().getArticleInfo();

        List<List<List<String>>> divided_list = new ArrayList<>();
        divided_list = this.makePages(info);

        app = new JFrame();

        home = new JPanel(new BorderLayout());

        search = new JTextField("Search", 120);
        search.setSize(new Dimension(300, 20));
        home.add(search, BorderLayout.SOUTH);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    searchController.execute(search.getText());
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btns = new JPanel();
        btns.setLayout(new GridLayout(1, 5));

        List<List<List<String>>> finalDivided_list = divided_list;

        currPage = 0;
        makeArticleButtons(divided_list.get(currPage));

        JPanel utilityButtons = new JPanel();
        JButton refresh = new JButton("Next");
        utilityButtons.add(refresh);
        home.add(utilityButtons, BorderLayout.WEST);
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display(finalDivided_list);
            }
        });

        JButton fav = new JButton("Favourites");
        JButton history = new JButton("History");
        utilityButtons.add(fav);
        utilityButtons.add(history);

        map = new JPanel();
        map.setPreferredSize(new Dimension(1200, 800));
        JLabel imgLabel = new JLabel(new ImageIcon("assets/map.png"));
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
        home.add(map, BorderLayout.CENTER);

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

    public void addToFavourites(String currState, JButton button){

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                button.setText("Unfavorite");
                // Add article to favourites


            } }); }

    public void makeCountryClick(JButton button, String country){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mapController.execute(country);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public List<List<List<String>>> makePages(List<List<String>> allArticles){
        List<List<List<String>>> pages = new ArrayList<>();
        List<List<String>> currList = new ArrayList<>();
        for (int i = 0; i < allArticles.size(); i++) {
            if (i % 5 == 0 && i !=0) {
                pages.add(new ArrayList<>(currList));
                currList.clear();
            }
            currList.add(allArticles.get(i));
        }

        if (!currList.isEmpty()) {
            pages.add(new ArrayList<>(currList));
        }
        return pages;
    }

    public void makeArticleButtons(List<List<String>> info) throws IOException {
        btns.removeAll();
        if (info.size() <=5){
            articles = new JButton[info.size()];
            for(int i = 0; i < info.size(); i++){

                articles[i] = new JButton();
                articles[i].setPreferredSize(new Dimension(290, 245));
                articles[i].setLayout(new BorderLayout());

                ArrayList<String> u = new ArrayList<String>(info.get(i));
                String Title = u.get(0);
                String ImageURL = u.get(1);
                String Description = u.get(2);
                String URL = u.get(3);
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

                JButton readMore = new JButton("Read More");
                JButton fav = new JButton("Favourite");
                readMore.setBounds(2,170, 100, 30);
                fav.setBounds(2, 200, 100, 30);
                article.add(readMore);
                article.add(fav);
                this.addToFavourites(fav.getText(), fav);

                articles[i].add(article);
                this.makeClick(URL, readMore);
                btns.add(articles[i]);
            }
            btns.revalidate();
            btns.repaint();
            home.add(btns, BorderLayout.NORTH);
        }
        else{
            System.out.println("more than 5 articles passed");
        }
    }

    private void display(List<List<List<String>>> desiredArticles){
        btns.removeAll();
        home.remove(btns);
        if (currPage == desiredArticles.size() - 1){
            currPage = 0;
            try {
                makeArticleButtons(desiredArticles.get(currPage));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else {
            currPage++;
            try {
                makeArticleButtons(desiredArticles.get(currPage));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        btns.revalidate();
        btns.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource().equals("MapState")){

        }
        if (evt.getSource().equals("SearchState")){

        }
        if (evt.getSource().equals("TopNewsState")){

        }
        if (evt.getSource().equals("SeeFavouritesState")){

        }
    }
}
