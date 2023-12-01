package use_case.History;


public class HistoryInteractor implements HistoryInputBoundary{

    final HistoryDataAccessInterface historyDataAccessObject;

    public HistoryInteractor(HistoryDataAccessInterface historyDataAccessObject) {
        this.historyDataAccessObject = historyDataAccessObject;
    }

    //    final FavouriteOutputBoundary favouritePresenter;
    @Override
    public void execute(HistoryInputData historyInputData) {
        historyDataAccessObject.addToHistory(historyInputData.getArticle(), historyInputData.getUsername());
    }
}
