package use_case.Map;

import entity.Article;
import entity.ArticleFactory;
import entity.KeywordArticleFactory;

import java.util.List;
import java.util.ArrayList;

public class MapInteractor implements MapInputBoundary{
    final MapOutputBoundary mapPresenter;
    /**
     * @param mapOutputBoundary */
    public MapInteractor(MapOutputBoundary mapOutputBoundary){
        this.mapPresenter = mapOutputBoundary;
    }

    /**
     * @param mapInputData */

    public void execute(MapInputData mapInputData) throws InterruptedException {
        ArticleFactory articleFactory = new KeywordArticleFactory(mapInputData.getCountryName());

        // n = -1 indicates "get all articles"
        List<Article> articles = articleFactory.createArticles(-1);
        List<List<String>> output = new ArrayList<>();
        for (Article a: articles) {
            List<String> x = new ArrayList<>();
            x.add(a.getTitle());
            x.add(a.getImageUrl());
            x.add(a.getDescription());
            x.add(a.getUrl());
            x.add(a.getPublishedAt());
            x.add(a.getAuthor());
            output.add(x);
        }
        MapOutputData mapOutputData = new MapOutputData(output);
        mapPresenter.prepareView(mapOutputData);
    }
}
