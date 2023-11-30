package interface_adapters.SeeFavourites;

import use_case.SeeFavourites.SeeFavouritesInputBoundary;
import use_case.SeeFavourites.SeeFavouritesInputData;

public class SeeFavouritesController {
    final SeeFavouritesInputBoundary seeFavouritesInteractor;

    public SeeFavouritesController(SeeFavouritesInputBoundary seeFavouritesInteractor) {
        this.seeFavouritesInteractor = seeFavouritesInteractor;
    }

    public void execute(String username) {
        SeeFavouritesInputData seeFavouritesInputData = new SeeFavouritesInputData(username);
        seeFavouritesInteractor.execute(seeFavouritesInputData);
    }
}
