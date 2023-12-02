package use_case.TopNews;

import entity.Article;
import entity.ArticleFactory;
import entity.TopNewsArticleFactory;

import java.util.ArrayList;
import java.util.List;

public class TopNewsInteractor implements TopNewsInputBoundary {
    final TopNewsOutputBoundary topNewsOutputPresenter;
    public TopNewsInteractor(TopNewsOutputBoundary topNewsOutputBoundary) {
        this.topNewsOutputPresenter = topNewsOutputBoundary;
    }
    @Override
    public void execute(TopNewsInputData topNewsInputData) throws InterruptedException {
        List<List<String>> globalArticles = new ArrayList<>();
        List<Integer> totalResults = new ArrayList<>();

        for(String country:SUPPORTED_COUNTRIES.getSupportedCountriesList()) {
            ArticleFactory articleFactory = new TopNewsArticleFactory(country);
            //obtain the total results for this country (don't need the articles)
            articleFactory.createArticles(0);
            // totalResults
            totalResults.add((Integer) articleFactory.getComputedData().get(0));
        }
        // use null for global top news articles
        ArticleFactory articleFactory = new TopNewsArticleFactory(null);
        List<Article> articles = articleFactory.createArticles(-1);
        // convert to string and extract select fields
        for (Article a: articles) {
            List<String> x = new ArrayList<>();
            x.add(a.getTitle());
            x.add(a.getImageUrl());
            x.add(a.getDescription());
            x.add(a.getUrl());
            x.add(a.getPublishedAt());
            x.add(a.getAuthor());
            globalArticles.add(x);
        }

        TopNewsOutputData topNewsOutputData = new TopNewsOutputData(globalArticles, totalResults);
        topNewsOutputPresenter.prepareSuccessView(topNewsOutputData);
    }
}
