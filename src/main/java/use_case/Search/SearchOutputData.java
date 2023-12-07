package use_case.Search;

import java.util.List;

public class SearchOutputData {
    private  List<List<String>> articles;

    /**
     *
     * @param articles
     */
    public SearchOutputData(List<List<String>> articles) {
        this.articles = articles;
    }

    /**
     *
     * @return articles
     * Getter method for related articles attribute
     */
    public List<List<String>> getArticles() {
        return articles;
    }
}
