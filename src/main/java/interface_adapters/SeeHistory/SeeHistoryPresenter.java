package interface_adapters.SeeHistory;


import interface_adapters.ViewManagerModel;
import use_case.SeeHistory.SeeHistoryOutputBoundary;
import use_case.SeeHistory.SeeHistoryOutputData;

public class SeeHistoryPresenter implements SeeHistoryOutputBoundary {
    private final SeeHistoryViewModel seeHistoryViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     *
     * @param seeHistoryViewModel
     * @param viewManagerModel
     */
    public SeeHistoryPresenter(SeeHistoryViewModel seeHistoryViewModel, ViewManagerModel viewManagerModel) {
        this.seeHistoryViewModel = seeHistoryViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     *
     * @param error
     * Prepares the view in case use case failed to produce output i.e. no previously visited articles existed for the use case
     */
    @Override
    public void prepareFailView(String error) {
        SeeHistoryState seeHistoryState = new SeeHistoryState();
        seeHistoryState.setError(error);
        this.seeHistoryViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(seeHistoryViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     *
     * @param seeHistoryOutputData
     */
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
