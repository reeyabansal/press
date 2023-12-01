package interface_adapters.SeeFavourites;

import use_case.SeeFavourites.SeeFavouritesOutputBoundary;
import use_case.SeeFavourites.SeeFavouritesOutputData;

public class SeeFavouritesPresenter implements SeeFavouritesOutputBoundary {
    private final SeeFavouritesViewModel seeFavouritesViewModel;

    public SeeFavouritesPresenter(SeeFavouritesViewModel seeFavouritesViewModel) {
        this.seeFavouritesViewModel = seeFavouritesViewModel;
    }

    @Override
    public void prepareFailView(String error) {
        SeeFavouritesState seeFavouritesState = seeFavouritesViewModel.getState();
        seeFavouritesState.setError(error);
        seeFavouritesViewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(SeeFavouritesOutputData seeFavouritesOutputData) {
        SeeFavouritesState seeFavouritesState = seeFavouritesViewModel.getState();
        seeFavouritesState.setArticles(seeFavouritesOutputData.getFavourites());
        this.seeFavouritesViewModel.setState(seeFavouritesState);
        seeFavouritesViewModel.firePropertyChanged();
    }
}
