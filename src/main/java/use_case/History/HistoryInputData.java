package use_case.History;

import java.util.List;

public class HistoryInputData {
    // Order of List Items: Title, ImageURL, Description, URL, PublishedAt, Author
    private List<String> article;

    public HistoryInputData(List<String> article){
        this.article = article;
    }

    public List<String> getArticle() {
        return article;
    }
}
