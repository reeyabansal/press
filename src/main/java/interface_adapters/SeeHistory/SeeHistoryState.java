package interface_adapters.SeeHistory;

import java.util.ArrayList;
import java.util.List;

public class SeeHistoryState {
    private List<List<String>> articles = new ArrayList<>();
    private String errorMessage;
    private boolean seeHistoryErrorMessage;

    public void setArticles(List<List<String>> articles) {
        this.articles = articles;
    }
    public List<List<String>> getArticles() {
        // Title, ImageURL, Description, URL, PublishedAt, Author
        seeHistoryErrorMessage = false;
        return articles;
    }

    public void setError(String error) {
        seeHistoryErrorMessage = true;
        this.errorMessage = error;
    }
}
