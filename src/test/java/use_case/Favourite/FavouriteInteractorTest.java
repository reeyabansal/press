package use_case.Favourite;

import data_access.FavouriteDataAccessObject;
import interface_adapters.Favourite.FavouritePresenter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FavouriteInteractorTest {

    class DummyFavouriteDAO implements FavouriteDataAccessInterface {
        public Map<String, List<List<String>>> favourites = new HashMap<>();

        @Override
        public void addFavourite(List<String> article, String username) {
            if (favourites.containsKey(username)) favourites.get(username).add(article);
            else {
                favourites.put(username, new ArrayList<>());
                favourites.get(username).add(article);
            }
        }
    }
    @Test
    void execute() {
        DummyFavouriteDAO favouriteDataAccessObject = new DummyFavouriteDAO();
        FavouriteInteractor favouriteInteractor = new FavouriteInteractor(favouriteDataAccessObject, new FavouritePresenter());
        List<String> article = new ArrayList<>();
        article.add("test contents");
        favouriteInteractor.execute(new FavouriteInputData(article, "user1"));
        assert(favouriteDataAccessObject.favourites.get("user1").size() == 1);
        assert(favouriteDataAccessObject.favourites.get("user1").get(0).get(0).equals("test contents"));
    }
}