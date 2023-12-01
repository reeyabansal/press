package use_case.History;

import java.util.List;

public interface HistoryDataAccessInterface {
    void addToHistory(List<String> article, String username);
}
