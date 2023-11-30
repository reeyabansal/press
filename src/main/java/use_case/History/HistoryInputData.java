package use_case.History;

import java.util.List;

public class HistoryInputData {
    // Order of List Items: Title, ImageURL, Description, URL, PublishedAt, Author
    private List<String> article;
    private String username;

    public HistoryInputData(List<String> article, String username){
        this.article = article;
        this.username = username;
    }

    public List<String> getArticle() {
        return article;
    }
}
