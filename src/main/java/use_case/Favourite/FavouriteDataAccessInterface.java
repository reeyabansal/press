package use_case.Favourite;

import java.util.List;

public interface FavouriteDataAccessInterface {
    void addFavourite(List<String> article, String username);
}
