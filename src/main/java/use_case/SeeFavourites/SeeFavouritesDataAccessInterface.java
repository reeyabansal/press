package use_case.SeeFavourites;

import java.util.List;

public interface SeeFavouritesDataAccessInterface {
    List<List<String>> getFavourites(String username);
}
