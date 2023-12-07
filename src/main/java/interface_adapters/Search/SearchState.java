package interface_adapters.Search;

import java.util.ArrayList;
import java.util.List;

public class SearchState {

    private List<List<String>> articles = new ArrayList<>();

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
        return articles;
    }
}
