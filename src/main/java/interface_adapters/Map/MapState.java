package interface_adapters.Map;

import java.util.ArrayList;
import java.util.List;

public class MapState {
    // Title, ImageURL, Description, URL, PublishedAt, Author
    private List<List<String>> articles = new ArrayList<>();
    private List<Integer> totalResults = new ArrayList<>();
    private List<Integer> sizes = new ArrayList<>();
    private boolean displayHotspots;
    public MapState() {
    }
    /**
     * @param articles*/
    public void setArticles(List<List<String>> articles) {
        this.articles = articles;
        System.out.println("map state set articles");
    }

    public List<List<String>> getArticles() {
        // Title, ImageURL, Description, URL, PublishedAt, Author
        return articles;
    }
    /**
     * @param totalResults*/
    public void setTotalResults(List<Integer> totalResults) {
        this.totalResults = totalResults;
    }

    public List<Integer> getTotalResults() {
        return totalResults;
    }

    public boolean getDisplayHotspots() {
        return displayHotspots;
    }
    /**
     * @param displayHotspots*/
    public void setDisplayHotspots(boolean displayHotspots) {
        this.displayHotspots = displayHotspots;
    }

    public List<Integer> getSizes() {
        return sizes;
    }
    /**
     * @param sizes
     * */
    public void setSizes(List<Integer> sizes) {
        this.sizes = sizes;
    }
}
