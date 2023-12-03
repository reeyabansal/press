package interface_adapters.SeeFavourites;

import interface_adapters.ViewManagerModel;
import use_case.SeeFavourites.SeeFavouritesOutputBoundary;
import use_case.SeeFavourites.SeeFavouritesOutputData;

public class SeeFavouritesPresenter implements SeeFavouritesOutputBoundary {
    private final SeeFavouritesViewModel seeFavouritesViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     *
     * @param seeFavouritesViewModel
     * @param viewManagerModel
     */
    public SeeFavouritesPresenter(SeeFavouritesViewModel seeFavouritesViewModel, ViewManagerModel viewManagerModel) {
        this.seeFavouritesViewModel = seeFavouritesViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     *
     * @param error
     * Prepares the view in case use case failed to produce output i.e. no previously visited articles existed for the use case
     */
    @Override
    public void prepareFailView(String error) {
        SeeFavouritesState seeFavouritesState = seeFavouritesViewModel.getState();
        seeFavouritesState.setError(error);
        seeFavouritesViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(seeFavouritesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     *
     * @param seeFavouritesOutputData
     */
    @Override
    public void prepareSuccessView(SeeFavouritesOutputData seeFavouritesOutputData) {
        SeeFavouritesState seeFavouritesState = seeFavouritesViewModel.getState();
        seeFavouritesState.setArticles(seeFavouritesOutputData.getFavourites());
        this.seeFavouritesViewModel.setState(seeFavouritesState);
        seeFavouritesViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(seeFavouritesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
