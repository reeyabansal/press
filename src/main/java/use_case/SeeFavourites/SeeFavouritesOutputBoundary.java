package use_case.SeeFavourites;

public interface SeeFavouritesOutputBoundary {
    void prepareFailView(String error);

    void prepareSuccessView(SeeFavouritesOutputData seeFavouritesOutputData);
}
