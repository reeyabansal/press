package use_case.SeeFavourites;

import org.junit.jupiter.api.Test;
import use_case.Search.SearchInputData;
import use_case.Search.SearchInteractor;
import use_case.SeeHistory.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SeeFavouritesInteractorTest {

    class DummySeeFavouritesDataAccessInterface implements SeeFavouritesDataAccessInterface {
        Map<String, List<List<String>>> favourites = new HashMap<>();
        DummySeeFavouritesDataAccessInterface() {
            List<String> article1 = new ArrayList<>();
            article1.add("title1");
            article1.add("other attributes 1");
            List<String> article2 = new ArrayList<>();
            article2.add("title2");
            article2.add("other attributes 2");
            List<List<String>> articles = new ArrayList<>();
            articles.add(article1);
            articles.add(article2);
            favourites.put("user1", articles);
            favourites.put("user2", new ArrayList<>());
        }

        @Override
        public List<List<String>> getFavourites(String username) {
            List<List<String>> out = new ArrayList<>();
            if(favourites.containsKey(username)) out = favourites.get(username);
            return out;
        }
    }

    class DummySeeFavouritesOutputBoundary implements SeeFavouritesOutputBoundary {
        String error = null;
        SeeFavouritesOutputData data = null;
        @Override
        public void prepareFailView(String error) {
            this.error = error;
        }

        @Override
        public void prepareSuccessView(SeeFavouritesOutputData seeFavouritesOutputData) {
            data = seeFavouritesOutputData;
        }
    }

    @Test
    void execute() {
        DummySeeFavouritesDataAccessInterface dataAccessInterface = new DummySeeFavouritesDataAccessInterface();
        DummySeeFavouritesOutputBoundary outputBoundary = new DummySeeFavouritesOutputBoundary();
        SeeFavouritesInteractor interactor = new SeeFavouritesInteractor(dataAccessInterface, outputBoundary);

        // test success
        interactor.execute(new SeeFavouritesInputData("user1"));
        assert(outputBoundary.data.getFavourites().size() == 2);
        assert(outputBoundary.data.getFavourites().get(0).get(0).equals("title1"));

        // test fail empty
        interactor.execute(new SeeFavouritesInputData("user2"));
        assert(outputBoundary.error.equals("Favourite articles could not be found."));
    }
}