package use_case.SeeFavourites;

import java.util.List;

public class SeeFavouritesInteractor implements SeeFavouritesInputBoundary {
    final SeeFavouritesDataAccessInterface favouriteDataAccessObject;
    final SeeFavouritesOutputBoundary seeFavouritesPresenter;

    /**
     *
     * @param favouriteDataAccessObject
     * @param seeFavouritesPresenter
     */
    public SeeFavouritesInteractor(SeeFavouritesDataAccessInterface favouriteDataAccessObject, SeeFavouritesOutputBoundary seeFavouritesPresenter) {
        this.favouriteDataAccessObject = favouriteDataAccessObject;
        this.seeFavouritesPresenter = seeFavouritesPresenter;
    }

    @Override
    public void execute(SeeFavouritesInputData seeFavouritesInputData) {
        List<List<String>> favourites = favouriteDataAccessObject.getFavourites(seeFavouritesInputData.getUsername());
        if (favourites.isEmpty()) {
            seeFavouritesPresenter.prepareFailView("Favourite articles could not be found.");
        } else {
            SeeFavouritesOutputData seeFavouritesOutputData = new SeeFavouritesOutputData(favourites);
            seeFavouritesPresenter.prepareSuccessView(seeFavouritesOutputData);
        }
    }
}
