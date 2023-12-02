package use_case.SeeHistory;

import java.util.List;

public interface SeeHistoryDataAccessInterface {
    List<List<String>> getHistory(String username);
}
