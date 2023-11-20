package use_case.Map;

import entity.Article;

import java.util.List;

public class MapOutputData {
    private final List<Article> articles;
//    private boolean useCaseFailed;

    public MapOutputData(List<Article> articles){
        this.articles = articles;
    }

    public List<Article> getArticles(){return articles;}

}
