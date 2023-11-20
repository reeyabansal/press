package interface_adapters.Map;

import java.util.ArrayList;
import java.util.List;

public class MapState {
    private List<List<String>> articles = new ArrayList<>();

    public MapState() {
    }

    public void setArticles(List<List<String>> articles) {
        this.articles = articles;
    }

    public List<List<String>> getArticles() {
        return articles;
    }
}
