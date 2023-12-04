package view;

import app.HomeScreenFactory;
import data_access.FavouriteDataAccessObject;
import data_access.HistoryDataAccessObject;
import interface_adapters.Favourite.FavouriteController;
import interface_adapters.Favourite.FavouriteViewModel;
import interface_adapters.History.HistoryController;
import interface_adapters.History.HistoryViewModel;
import interface_adapters.LoggedIn.LoggedInViewModel;
import interface_adapters.Map.MapController;
import interface_adapters.Map.MapPresenter;
import interface_adapters.Map.MapViewModel;
import interface_adapters.Search.SearchController;
import interface_adapters.Search.SearchViewModel;
import interface_adapters.SeeFavourites.SeeFavouritesController;
import interface_adapters.SeeFavourites.SeeFavouritesViewModel;
import interface_adapters.SeeHistory.SeeHistoryController;
import interface_adapters.SeeHistory.SeeHistoryViewModel;
import interface_adapters.TopNews.TopNewsViewModel;
import interface_adapters.ViewManagerModel;
import interface_adapters.login.LoginViewModel;
import interface_adapters.signup.SignupViewModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import use_case.Favourite.FavouriteDataAccessInterface;
import use_case.History.HistoryDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HomeScreenTest {
    HomeScreen homeScreen = null;

    @BeforeAll
    void init() throws IOException {
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
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        homeScreen = HomeScreenFactory.create(
                viewManagerModel,  mapViewModel, topNewsViewModel, searchViewModel, favouriteViewModel,
                seeFavouritesViewModel, historyViewModel, seeHistoryViewModel, new FavouriteDataAccessObject(),
                new HistoryDataAccessObject(), loggedInViewModel);
        assert(true);
    }

    @Test
    void makeClick() {
    }

    @Test
    void addToFavourites() {
    }

    @Test
    void makeCountryClick() {
    }

    @Test
    void makePages() {
    }

    @Test
    void makeArticleButtons() {
    }

    @Test
    void actionPerformed() {
    }

    @Test
    void propertyChange() {
    }
}