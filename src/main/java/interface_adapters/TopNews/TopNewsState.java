package interface_adapters.TopNews;

import java.util.ArrayList;
import java.util.List;

public class TopNewsState {
    // Title, ImageURL, Description, URL, PublishedAt, Author
    List<List<String>> articleInfo;
    List<Integer> totalResults;
    List<Integer> sizes;

    public TopNewsState(){
        sizes = new ArrayList<>();
    }

    public List<List<String>> getArticleInfo() {
        return articleInfo;
    }

    public void setArticleInfo(List<List<String>> articleInfo) {
        this.articleInfo = articleInfo;
    }

    public List<Integer> getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(List<Integer> totalResults) {
        this.totalResults = totalResults;
    }

    public List<Integer> getSizes() {
        return sizes;
    }

    public void setSizes(List<Integer> sizes) {
        this.sizes = sizes;
    }

    // min 20
    // max 60
}
