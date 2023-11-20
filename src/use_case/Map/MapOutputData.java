package use_case.Map;

import entity.Article;

import java.util.List;

public class MapOutputData {
    private final List<List<String>> articles;
//    private boolean useCaseFailed;

    public MapOutputData(List<List<String>> articles){
        this.articles = articles;
    }

    public List<Article> getArticles(){return articles;}

}
