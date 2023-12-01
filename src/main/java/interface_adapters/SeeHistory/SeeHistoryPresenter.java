package interface_adapters.SeeHistory;


import interface_adapters.ViewManagerModel;
import use_case.SeeHistory.SeeHistoryOutputBoundary;
import use_case.SeeHistory.SeeHistoryOutputData;

public class SeeHistoryPresenter implements SeeHistoryOutputBoundary {
    private final SeeHistoryViewModel seeHistoryViewModel;
    private final ViewManagerModel viewManagerModel;

    public SeeHistoryPresenter(SeeHistoryViewModel seeHistoryViewModel, ViewManagerModel viewManagerModel) {
        this.seeHistoryViewModel = seeHistoryViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareFailView(String error) {
        SeeHistoryState seeHistoryState = new SeeHistoryState();
        seeHistoryState.setError(error);
        this.seeHistoryViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(seeHistoryViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(SeeHistoryOutputData seeHistoryOutputData) {
        SeeHistoryState seeHistoryState = new SeeHistoryState();
        seeHistoryState.setArticles(seeHistoryOutputData.getVisited());
        this.seeHistoryViewModel.setState(seeHistoryState);
        this.seeHistoryViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(seeHistoryViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
