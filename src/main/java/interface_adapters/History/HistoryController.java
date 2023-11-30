package interface_adapters.History;

import use_case.History.HistoryInputBoundary;
import use_case.History.HistoryInputData;

import java.util.List;

public class HistoryController {
    final HistoryInputBoundary historyInteractor;
    public HistoryController(HistoryInputBoundary historyInteractor) {
        this.historyInteractor = historyInteractor;
    }

    public void execute(List<String> article, String username) {
        HistoryInputData historyInputData = new HistoryInputData(article, username);

        historyInteractor.execute(historyInputData);
    }
}
