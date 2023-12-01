package use_case.History;

import java.util.List;

public class HistoryInputData {
    // Order of List Items: Title, ImageURL, Description, URL, PublishedAt, Author
    private final List<String> article;
    private final String username;

    public HistoryInputData(List<String> article, String username){
        this.article = article;
        this.username = username;
    }

    public List<String> getArticle() {
        return article;
    }

    public String getUsername() {
        return username;
    }
}
