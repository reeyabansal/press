package app;

import data_access.FavouriteDataAccessObject;
import data_access.HistoryDataAccessObject;
import interface_adapters.Favourite.FavouriteController;
import interface_adapters.Favourite.FavouritePresenter;
import interface_adapters.Favourite.FavouriteViewModel;
import interface_adapters.History.HistoryController;
import interface_adapters.History.HistoryPresenter;
import interface_adapters.History.HistoryViewModel;
import interface_adapters.Map.MapController;
import interface_adapters.Map.MapPresenter;
import interface_adapters.Map.MapViewModel;
import interface_adapters.Search.SearchController;
import interface_adapters.Search.SearchPresenter;
import interface_adapters.Search.SearchViewModel;
import interface_adapters.SeeFavourites.SeeFavouritesController;
import interface_adapters.SeeFavourites.SeeFavouritesPresenter;
import interface_adapters.SeeFavourites.SeeFavouritesViewModel;
import interface_adapters.SeeHistory.SeeHistoryController;
import interface_adapters.SeeHistory.SeeHistoryPresenter;
import interface_adapters.SeeHistory.SeeHistoryViewModel;
import interface_adapters.TopNews.TopNewsController;
import interface_adapters.TopNews.TopNewsPresenter;
import interface_adapters.TopNews.TopNewsViewModel;
import interface_adapters.ViewManagerModel;
import use_case.Favourite.FavouriteInputBoundary;
import use_case.Favourite.FavouriteInteractor;
import use_case.Favourite.FavouriteOutputBoundary;
import use_case.History.HistoryInputBoundary;
import use_case.History.HistoryInteractor;
import use_case.History.HistoryOutputBoundary;
import use_case.Map.MapInputBoundary;
import use_case.Map.MapInteractor;
import use_case.Map.MapOutputBoundary;
import use_case.Search.SearchInputBoundary;
import use_case.Search.SearchInteractor;
import use_case.Search.SearchOutputBoundary;
import use_case.SeeFavourites.SeeFavouritesInputBoundary;
import use_case.SeeFavourites.SeeFavouritesInteractor;
import use_case.SeeFavourites.SeeFavouritesOutputBoundary;
import use_case.SeeHistory.SeeHistoryInputBoundary;
import use_case.SeeHistory.SeeHistoryInteractor;
import use_case.SeeHistory.SeeHistoryOutputBoundary;
import use_case.TopNews.TopNewsInputBoundary;
import use_case.TopNews.TopNewsInteractor;
import use_case.TopNews.TopNewsOutputBoundary;
import view.HomeScreen;

import javax.swing.*;
import java.io.IOException;

public class HomeScreenFactory {
    public static HomeScreen create(ViewManagerModel viewManagerModel, MapViewModel mapViewModel, TopNewsViewModel topNewsViewModel, SearchViewModel searchViewModel, FavouriteViewModel favouriteViewModel, SeeFavouritesViewModel seeFavouritesViewModel, HistoryViewModel historyViewModel, SeeHistoryViewModel seeHistoryViewModel, FavouriteDataAccessObject favouriteDataAccessObject, HistoryDataAccessObject historyDataAccessObject) {
        try {
            MapController mapController = createMapUseCase(viewManagerModel, mapViewModel);
            TopNewsController topNewsController = createTopNewsUseCase(viewManagerModel, topNewsViewModel);
            SearchController searchController = createSearchUseCase(viewManagerModel, searchViewModel);
            FavouriteController favouriteController = createFavouriteUseCase(viewManagerModel, favouriteViewModel, favouriteDataAccessObject);
            SeeFavouritesController seeFavouritesController = createSeeFavouritesUseCase(viewManagerModel, seeFavouritesViewModel, favouriteDataAccessObject);
            HistoryController historyController = createHistoryUseCase(viewManagerModel, historyViewModel, historyDataAccessObject);
            SeeHistoryController seeHistoryController = createSeeHistoryUseCase(viewManagerModel, seeHistoryViewModel, historyDataAccessObject);

            // TODO: Add attributes
            return new HomeScreen();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error occurred.");
        }

        return null;
    }

    private static SeeHistoryController createSeeHistoryUseCase(ViewManagerModel viewManagerModel, SeeHistoryViewModel seeHistoryViewModel, HistoryDataAccessObject historyDataAccessObject) {
        SeeHistoryOutputBoundary seeHistoryOutputBoundary = new SeeHistoryPresenter(seeHistoryViewModel, viewManagerModel);

        SeeHistoryInputBoundary seeHistoryInteractor = new SeeHistoryInteractor(historyDataAccessObject, seeHistoryOutputBoundary);

        return new SeeHistoryController(seeHistoryInteractor);
    }

    private static HistoryController createHistoryUseCase(ViewManagerModel viewManagerModel, HistoryViewModel historyViewModel, HistoryDataAccessObject historyDataAccessObject) {
        HistoryOutputBoundary historyOutputBoundary = new HistoryPresenter();

        HistoryInputBoundary historyInteractor = new HistoryInteractor(historyDataAccessObject, historyOutputBoundary);

        return new HistoryController(historyInteractor);
    }

    private static MapController createMapUseCase(ViewManagerModel viewManagerModel, MapViewModel mapViewModel) {
        MapOutputBoundary mapOutputBoundary = new MapPresenter(mapViewModel, viewManagerModel);

        MapInputBoundary mapInteractor = new MapInteractor(mapOutputBoundary);

        return new MapController(mapInteractor);
    }

    private static TopNewsController createTopNewsUseCase(ViewManagerModel viewManagerModel, TopNewsViewModel topNewsViewModel) {
        TopNewsOutputBoundary topNewsOutputBoundary = new TopNewsPresenter(topNewsViewModel, viewManagerModel);

        TopNewsInputBoundary topNewsInteractor = new TopNewsInteractor(topNewsOutputBoundary);

        return new TopNewsController(topNewsInteractor);
    }

    private static SearchController createSearchUseCase(ViewManagerModel viewManagerModel, SearchViewModel searchViewModel) {
        SearchOutputBoundary searchOutputBoundary = new SearchPresenter(searchViewModel, viewManagerModel);

        SearchInputBoundary searchInteractor = new SearchInteractor(searchOutputBoundary);

        return new SearchController(searchInteractor);
    }

    private static FavouriteController createFavouriteUseCase(ViewManagerModel viewManagerModel, FavouriteViewModel favouriteViewModel, FavouriteDataAccessObject favouriteDataAccessObject) {
        FavouriteOutputBoundary favouriteOutputBoundary = new FavouritePresenter();

        FavouriteInputBoundary favouriteInteractor = new FavouriteInteractor(favouriteDataAccessObject, favouriteOutputBoundary);

        return new FavouriteController(favouriteInteractor);
    }

    private static SeeFavouritesController createSeeFavouritesUseCase(ViewManagerModel viewManagerModel, SeeFavouritesViewModel seeFavouritesViewModel, FavouriteDataAccessObject favouriteDataAccessObject) {
        SeeFavouritesOutputBoundary seeFavouritesOutputBoundary = new SeeFavouritesPresenter(seeFavouritesViewModel, viewManagerModel);

        SeeFavouritesInputBoundary seeFavouritesInteractor = new SeeFavouritesInteractor(favouriteDataAccessObject, seeFavouritesOutputBoundary);

        return new SeeFavouritesController(seeFavouritesInteractor);
    }
}
