package use_case.Map;

import DataAccess.NewsAPICountry;
import entity.Article;
import entity.ArticleFactory;
import entity.CommonArticle;

import java.util.List;
import java.util.ArrayList;

public class MapInteractor implements MapInputBoundary{
    final MapOutputBoundary mapPresenter;
    public MapInteractor(MapOutputBoundary mapOutputBoundary){
        this.mapPresenter = mapOutputBoundary;
    }

    public void execute(MapInputData mapInputData) {
        ArticleFactory articleFactory = new NewsAPICountry();

        // n = -1 indicates "get all articles"
        List<Article> articles = articleFactory.createArticles(mapInputData.getCountryName(), -1);
        MapOutputData mapOutputData = new MapOutputData(articles);
        mapPresenter.prepareView(mapOutputData);
    }
}
