package use_case.Favourite;

import data_access.FavouriteDataAccessObject;

public class FavouriteInteractor implements  FavouriteInputBoundary {

    @Override
    public void execute(FavouriteInputData favouriteInputData) {
        // favouriteInputData has to be stored through data_access
        FavouriteDataAccessObject favouriteDataAccessObject = new FavouriteDataAccessObject();
        favouriteDataAccessObject.addFavourite(favouriteInputData.getArticle(), favouriteInputData.getUsername());
    }
}
