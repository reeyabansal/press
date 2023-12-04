package app;

import data_access.FavouriteDataAccessObject;
import data_access.FileUserDataAccessObject;
import data_access.HistoryDataAccessObject;
import entity.CommonUserFactory;
import interface_adapters.Favourite.FavouriteViewModel;
import interface_adapters.History.HistoryViewModel;
import interface_adapters.LoggedIn.LoggedInViewModel;
import interface_adapters.Login.LoginViewModel;
import interface_adapters.Map.MapViewModel;
import interface_adapters.Search.SearchViewModel;
import interface_adapters.SeeFavourites.SeeFavouritesViewModel;
import interface_adapters.SeeHistory.SeeHistoryViewModel;
import interface_adapters.Signup.SignupViewModel;
import interface_adapters.TopNews.TopNewsViewModel;
import interface_adapters.ViewManagerModel;
import view.*;

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
        new ViewManager(views, cardLayout, viewManagerModel);

        MapViewModel mapViewModel = new MapViewModel();
        TopNewsViewModel topNewsViewModel = new TopNewsViewModel();
        SearchViewModel searchViewModel = new SearchViewModel();
        FavouriteViewModel favouriteViewModel = new FavouriteViewModel();
        SeeFavouritesViewModel seeFavouritesViewModel = new SeeFavouritesViewModel();
        HistoryViewModel historyViewModel = new HistoryViewModel();
        SeeHistoryViewModel seeHistoryViewModel = new SeeHistoryViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();

        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FavouriteDataAccessObject favouriteDataAccessObject;
        try {
            favouriteDataAccessObject = new FavouriteDataAccessObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HistoryDataAccessObject historyDataAccessObject;
        try {
            historyDataAccessObject = new HistoryDataAccessObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        OpeningScreen openingScreen = new OpeningScreen();
//        SignupScreen signupScreen = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject);
//        LoginScreen loginScreen = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
        HomeScreen homeScreen = HomeScreenFactory.create(viewManagerModel, mapViewModel, topNewsViewModel, searchViewModel, favouriteViewModel, seeFavouritesViewModel, historyViewModel, seeHistoryViewModel, favouriteDataAccessObject, historyDataAccessObject, loggedInViewModel);

//        views.add(openingScreen, openingScreen.viewName);
//        assert signupScreen != null;
//        views.add(signupScreen, signupScreen.viewName);
//        assert loginScreen != null;
//        views.add(loginScreen, loginScreen.viewName);
        assert homeScreen != null;
        views.add(homeScreen, homeScreen.viewName);

        viewManagerModel.setActiveView(homeScreen.viewName);
//        viewManagerModel.setActiveView(openingScreen.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
