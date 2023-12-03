package interface_adapters.SeeFavourites;

import use_case.SeeFavourites.SeeFavouritesInputBoundary;
import use_case.SeeFavourites.SeeFavouritesInputData;

public class SeeFavouritesController {
    final SeeFavouritesInputBoundary seeFavouritesInteractor;

    /**
     *
     * @param seeFavouritesInteractor
     *
     */
    public SeeFavouritesController(SeeFavouritesInputBoundary seeFavouritesInteractor) {
        this.seeFavouritesInteractor = seeFavouritesInteractor;
    }

    /**
     *
     * @param username
     *
     */
    public void execute(String username) {
        SeeFavouritesInputData seeFavouritesInputData = new SeeFavouritesInputData(username);
        seeFavouritesInteractor.execute(seeFavouritesInputData);
    }
}
