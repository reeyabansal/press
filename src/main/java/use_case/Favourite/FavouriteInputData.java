package use_case.Favourite;

import java.util.List;

public class FavouriteInputData {
    final private List<String> article;
    final private String username;

    /**
     *
     * @param article
     * @param username
     */
    public FavouriteInputData(List<String> article, String username) {
        this.article = article;
        this.username = username;
    }

    /**
     *
     * @return article
     * Getter method for article attribute
     */
    public List<String> getArticle() {
        return article;
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
