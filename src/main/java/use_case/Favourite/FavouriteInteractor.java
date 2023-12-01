package use_case.Favourite;

import data_access.FavouriteDataAccessObject;

public class FavouriteInteractor implements  FavouriteInputBoundary {
    final FavouriteDataAccessInterface favouriteDataAccessObject;
    final FavouriteOutputBoundary favouritePresenter;

    public FavouriteInteractor(FavouriteDataAccessInterface favouriteDataAccessObject, FavouriteOutputBoundary favouritePresenter) {
        this.favouriteDataAccessObject = favouriteDataAccessObject;
        this.favouritePresenter = favouritePresenter;
    }

    @Override
    public void execute(FavouriteInputData favouriteInputData) {
        final

        // favouriteInputData has to be stored through data_access
        FavouriteDataAccessObject favouriteDataAccessObject = new FavouriteDataAccessObject();
        favouriteDataAccessObject.addFavourite(favouriteInputData.getArticle(), favouriteInputData.getUsername());
    }
}
