package use_case.Map;

import entity.Article;

import java.util.List;

public class MapOutputData {
    private  List<List<String>> articles;
//    private boolean useCaseFailed;
    /**
     * @param articles */
    public MapOutputData(List<List<String>> articles){
        this.articles = articles;
    }

    public List<List<String>> getArticles() {
        return articles;
    }
}
