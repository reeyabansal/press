package use_case.Map;

import entity.CommonArticle;

import java.util.ArrayList;

public class MapOutputData {
    private final ArrayList<CommonArticle> articles;
//    private boolean useCaseFailed;

    public MapOutputData(ArrayList<CommonArticle> articles){
        this.articles = articles;
    }

    public ArrayList<CommonArticle> getArticles(){return articles;}

}
