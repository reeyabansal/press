package interface_adapters.Favourite;

import use_case.Favourite.FavouriteInputBoundary;
import use_case.Favourite.FavouriteInputData;

import java.util.List;

public class FavouriteController {
    final FavouriteInputBoundary favouriteInteractor;

    /**
     *
     * @param favouriteInteractor
     */
    public FavouriteController(FavouriteInputBoundary favouriteInteractor) {
        this.favouriteInteractor = favouriteInteractor;
    }

    /**
     *
     * @param article
     * @param username
     */
    public void execute(List<String> article, String username) {
        FavouriteInputData favouriteInputData = new FavouriteInputData(article, username);
        favouriteInteractor.execute(favouriteInputData);
    }
}
