package interface_adapters.SeeHistory;


import use_case.SeeHistory.SeeHistoryOutputBoundary;
import use_case.SeeHistory.SeeHistoryOutputData;

public class SeeHistoryPresenter implements SeeHistoryOutputBoundary {
    private final SeeHistoryViewModel seeHistoryViewModel;

    public SeeHistoryPresenter(SeeHistoryViewModel seeHistoryViewModel) {
        this.seeHistoryViewModel = seeHistoryViewModel;
    }

    @Override
    public void prepareFailView(String error) {
        SeeHistoryState seeHistoryState = new SeeHistoryState();
        seeHistoryState.setError(error);
        this.seeHistoryViewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(SeeHistoryOutputData seeHistoryOutputData) {
        SeeHistoryState seeHistoryState = new SeeHistoryState();
        seeHistoryState.setArticles(seeHistoryOutputData.getVisited());
        this.seeHistoryViewModel.setState(seeHistoryState);
        this.seeHistoryViewModel.firePropertyChanged();
    }
}
