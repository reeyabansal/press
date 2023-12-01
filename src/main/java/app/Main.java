package app;

import app.view.HomeScreen;
import interface_adapters.Map.MapController;
import interface_adapters.Map.MapViewModel;
import interface_adapters.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Login Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
//        new ViewManager(views, cardLayout, viewManagerModel);

        // Add all view models
        MapViewModel mapViewModel = new MapViewModel();


//        FileUserDataAccessObject userDataAccessObject;
//        try {
//            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        //MapController mapController = new MapController();

        /*HomeScreen homeScreen = new HomeScreen();
        views.add(homeScreen, homeScreen.viewName);*/


        application.pack();
        application.setVisible(true);
    }
}
