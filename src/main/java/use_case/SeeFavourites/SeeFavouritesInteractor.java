package use_case.SeeFavourites;

import java.util.List;

public class SeeFavouritesInteractor implements SeeFavouritesInputBoundary {
    final SeeFavouritesDataAccessInterface seeFavouritesDataAccessObject;
    final SeeFavouritesOutputBoundary seeFavouritesPresenter;

    public SeeFavouritesInteractor(SeeFavouritesDataAccessInterface seeFavouritesDataAccessObject, SeeFavouritesOutputBoundary seeFavouritesPresenter) {
        this.seeFavouritesDataAccessObject = seeFavouritesDataAccessObject;
        this.seeFavouritesPresenter = seeFavouritesPresenter;
    }

    @Override
    public void execute(SeeFavouritesInputData seeFavouritesInputData) {
        List<List<String>> favourites = seeFavouritesDataAccessObject.getFavourites(seeFavouritesInputData.getUsername());
        if (favourites.isEmpty()) {
            seeFavouritesPresenter.prepareFailView("Favourite articles could not be found.");
        } else {
            SeeFavouritesOutputData seeFavouritesOutputData = new SeeFavouritesOutputData(favourites);
            seeFavouritesPresenter.prepareSuccessView(seeFavouritesOutputData);
        }
    }
}
