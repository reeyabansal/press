package interface_adapters.SeeHistory;

import use_case.SeeHistory.SeeHistoryInputBoundary;
import use_case.SeeHistory.SeeHistoryInputData;

public class SeeHistoryController {
    final SeeHistoryInputBoundary seeHistoryInteractor;

    public SeeHistoryController(SeeHistoryInputBoundary seeHistoryInteractor) {
        this.seeHistoryInteractor = seeHistoryInteractor;
    }

    public void execute(String username) {
        SeeHistoryInputData seeHistoryInputData = new SeeHistoryInputData(username);
        seeHistoryInteractor.execute(seeHistoryInputData);
    }
}
