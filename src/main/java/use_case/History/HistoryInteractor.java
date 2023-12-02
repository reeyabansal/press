package use_case.History;


public class HistoryInteractor implements HistoryInputBoundary{

    final HistoryDataAccessInterface historyDataAccessObject;
    final HistoryOutputBoundary historyPresenter;

    /**
     *
     * @param historyDataAccessObject
     * @param historyPresenter
     */
    public HistoryInteractor(HistoryDataAccessInterface historyDataAccessObject, HistoryOutputBoundary historyPresenter) {
        this.historyDataAccessObject = historyDataAccessObject;
        this.historyPresenter = historyPresenter;
    }

    /**
     *
     * @param historyInputData
     * Adds to history using the historyDataAccessObject. No presenter called as this use case must not change the view in any way
     */
    @Override
    public void execute(HistoryInputData historyInputData) {
        historyDataAccessObject.addToHistory(historyInputData.getArticle(), historyInputData.getUsername());
    }
}
