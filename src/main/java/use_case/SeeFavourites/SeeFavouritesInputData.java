package use_case.SeeFavourites;

public class SeeFavouritesInputData {
    final private String username;

    public SeeFavouritesInputData(String username) {
        this.username = username;
    }

    /**
     *
     * @return username
     * Getter method for username attribute
     */
    public String getUsername() {
        return username;
    }
}
