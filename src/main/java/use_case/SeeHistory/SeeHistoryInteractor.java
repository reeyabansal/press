package use_case.SeeHistory;

import java.util.List;

public class SeeHistoryInteractor implements SeeHistoryInputBoundary{
    final SeeHistoryDataAccessInterface seeHistoryDataAccessObject;
    final SeeHistoryOutputBoundary seeHistoryPresenter;

    /**
     *
     * @param historyDataAccessObject
     * @param seeHistoryPresenter
     */
    public SeeHistoryInteractor(SeeHistoryDataAccessInterface historyDataAccessObject, SeeHistoryOutputBoundary seeHistoryPresenter) {
        this.seeHistoryDataAccessObject = historyDataAccessObject;
        this.seeHistoryPresenter = seeHistoryPresenter;
    }

    /**
     *
     * @param seeHistoryInputData
     * Gets the articles visited by the user previously. If no articles were visited, it moves to Fail view otherwise goes to Success view
     */
    public void execute(SeeHistoryInputData seeHistoryInputData) {
        List<List<String>> visited = seeHistoryDataAccessObject.getHistory(seeHistoryInputData.getUsername());
        if (visited.isEmpty()) {
            seeHistoryPresenter.prepareFailView("No articles visited yet.");
        }
        else {
            SeeHistoryOutputData seeHistoryOutputData = new SeeHistoryOutputData(visited);
            seeHistoryPresenter.prepareSuccessView(seeHistoryOutputData);
        }
    }
}
