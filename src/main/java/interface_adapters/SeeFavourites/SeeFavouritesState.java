package interface_adapters.SeeFavourites;

import java.util.ArrayList;
import java.util.List;

public class SeeFavouritesState {
    private List<List<String>> articles = new ArrayList<>();
    private String errorMessage;
    private boolean seeFavouritesError;

    /**
     *
     * @param articles
     */
    public void setArticles(List<List<String>> articles) {
        this.articles = articles;
    }

    /**
     *
     * @return
     */
    public List<List<String>> getArticles() {
        // Title, ImageURL, Description, URL, PublishedAt, Author
        seeFavouritesError = false;
        return articles;
    }

    /**
     *
     * @param error
     */
    public void setError(String error) {
        seeFavouritesError = true;
        this.errorMessage = error;
    }
}
