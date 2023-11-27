package use_case.Search;

import java.util.List;

public class SearchOutputData {
    private  List<List<String>> articles;

    public SearchOutputData(List<List<String>> articles) {
        this.articles = articles;
    }

    public List<List<String>> getArticles() {
        return articles;
    }
}
