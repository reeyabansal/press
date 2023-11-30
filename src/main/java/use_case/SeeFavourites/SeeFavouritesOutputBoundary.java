package use_case.SeeFavourites;

public interface SeeFavouritesOutputBoundary {
    void prepareFailView();

    void prepareSuccessView(SeeFavouritesOutputData seeFavouritesOutputData);
}
