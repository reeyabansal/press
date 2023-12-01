package use_case.SeeFavourites;

import java.util.List;

public class SeeFavouritesOutputData {
    private List<List<String>> favourites;

    public SeeFavouritesOutputData(List<List<String>> favourites) {
        this.favourites = favourites;
    }

    public List<List<String>> getFavourites() {
        return favourites;
    }
}
