package interface_adapters.SeeFavourites;

import interface_adapters.ViewManagerModel;
import use_case.SeeFavourites.SeeFavouritesOutputBoundary;
import use_case.SeeFavourites.SeeFavouritesOutputData;

public class SeeFavouritesPresenter implements SeeFavouritesOutputBoundary {
    private final SeeFavouritesViewModel seeFavouritesViewModel;
    private final ViewManagerModel viewManagerModel;

    public SeeFavouritesPresenter(SeeFavouritesViewModel seeFavouritesViewModel, ViewManagerModel viewManagerModel) {
        this.seeFavouritesViewModel = seeFavouritesViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareFailView(String error) {
        SeeFavouritesState seeFavouritesState = seeFavouritesViewModel.getState();
        seeFavouritesState.setError(error);
        seeFavouritesViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(seeFavouritesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

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
