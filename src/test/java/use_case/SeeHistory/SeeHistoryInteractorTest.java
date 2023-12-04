package use_case.SeeHistory;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SeeHistoryInteractorTest {
    class DummySeeHistoryDataAccessInterface implements SeeHistoryDataAccessInterface {
        Map<String, List<List<String>>> history = new HashMap<>();
        DummySeeHistoryDataAccessInterface() {
            List<String> article1 = new ArrayList<>();
            article1.add("title1");
            article1.add("other attributes 1");
            List<String> article2 = new ArrayList<>();
            article2.add("title2");
            article2.add("other attributes 2");
            List<List<String>> articles = new ArrayList<>();
            articles.add(article1);
            articles.add(article2);
            history.put("user1", articles);
            history.put("user2", new ArrayList<>());
        }
        @Override
        public List<List<String>> getHistory(String username) {
            List<List<String>> out = new ArrayList<>();
            if(history.containsKey(username)) out = history.get(username);
            return out;
        }
    }

    class DummyHistoryOutputBoundary implements SeeHistoryOutputBoundary {
        String error = null;
        SeeHistoryOutputData data = null;
        @Override
        public void prepareFailView(String error) {
            this.error = error;
        }

        @Override
        public void prepareSuccessView(SeeHistoryOutputData seeHistoryOutputData) {
            data = seeHistoryOutputData;
        }
    }

    @Test
    void execute() {
        DummySeeHistoryDataAccessInterface dataAccessInterface = new DummySeeHistoryDataAccessInterface();
        DummyHistoryOutputBoundary outputBoundary = new DummyHistoryOutputBoundary();
        SeeHistoryInteractor interactor = new SeeHistoryInteractor(dataAccessInterface, outputBoundary);

        // test success
        interactor.execute(new SeeHistoryInputData("user1"));
        assert(outputBoundary.data.getVisited().size() == 2);
        assert(outputBoundary.data.getVisited().get(0).get(0).equals("title1"));

        // test fail empty
        interactor.execute(new SeeHistoryInputData("user2"));
        assert(outputBoundary.error.equals("No articles visited yet."));
    }
}