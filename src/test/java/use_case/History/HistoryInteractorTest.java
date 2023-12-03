package use_case.History;

import interface_adapters.History.HistoryPresenter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HistoryInteractorTest {
    class DummyHistoryDataAccessInterface implements HistoryDataAccessInterface {
        public Map<String, List<List<String>>> history = new HashMap<>();
        @Override
        public void addToHistory(List<String> article, String username) {
            if(history.containsKey(username)) history.get(username).add(article);
            else {
                history.put(username, new ArrayList<>());
                history.get(username).add(article);
            }
        }
    }


    @Test
    void execute() {
        DummyHistoryDataAccessInterface dataAccessInterface = new DummyHistoryDataAccessInterface();
        HistoryInteractor interactor = new HistoryInteractor(dataAccessInterface, new HistoryPresenter());
        List<String> article = new ArrayList<>();
        article.add("title1");
        interactor.execute(new HistoryInputData(article, "user1"));
        assert(dataAccessInterface.history.containsKey("user1"));
        assert(dataAccessInterface.history.get("user1").get(0).get(0).equals("title1"));
    }
}