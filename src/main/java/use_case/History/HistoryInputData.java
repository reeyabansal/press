package use_case.History;

import java.util.List;

public class HistoryInputData {
    // Order of List Items: Title, ImageURL, Description, URL, PublishedAt, Author
    private final List<String> article;
    private final String username;

    /**
     *
     * @param article
     * @param username
     */
    public HistoryInputData(List<String> article, String username){
        this.article = article;
        this.username = username;
    }

    /**
     *
     * @return article
     * Getter method for article atribute
     */
    public List<String> getArticle() {
        return article;
    }

    /**
     *
     * @return username
     * Getter method for username atribute
     */
    public String getUsername() {
        return username;
    }
}
