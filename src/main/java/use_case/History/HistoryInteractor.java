package use_case.History;


public class HistoryInteractor implements HistoryInputBoundary{

    final HistoryDataAccessInterface historyDataAccessObject;
    final HistoryOutputBoundary historyPresenter;

    public HistoryInteractor(HistoryDataAccessInterface historyDataAccessObject, HistoryOutputBoundary historyPresenter) {
        this.historyDataAccessObject = historyDataAccessObject;
        this.historyPresenter = historyPresenter;
    }

    @Override
    public void execute(HistoryInputData historyInputData) {
        historyDataAccessObject.addToHistory(historyInputData.getArticle(), historyInputData.getUsername());
    }
}
