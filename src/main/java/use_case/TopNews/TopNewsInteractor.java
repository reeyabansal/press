package use_case.TopNews;

import data_access.NewsAPITop;
import entity.Article;

import java.util.ArrayList;
import java.util.List;

public class TopNewsInteractor implements TopNewsInputBoundary {
    final TopNewsOutputBoundary topNewsOutputPresenter;
    public TopNewsInteractor(TopNewsOutputBoundary topNewsOutputBoundary) {
        this.topNewsOutputPresenter = topNewsOutputBoundary;
    }
    @Override
    public void execute(TopNewsInputData topNewsInputData) throws InterruptedException {
        NewsAPITop articleFactory = new NewsAPITop();
        List<List<List<String>>> countriesArticles = new ArrayList<>();
        List<Integer> totalResults = new ArrayList<>();

        for(String country:SUPPORTED_COUNTRIES.getSupportedCountriesList()) {
            // n = -1 indicates "get all articles"
            List<Article> articles = articleFactory.createArticles(country, -1);
            List<List<String>> countryArticles = new ArrayList<>();
            // convert to string and extract select fields
            for (Article a: articles) {
                List<String> x = new ArrayList<>();
                x.add(a.getTitle());
                x.add(a.getImageUrl());
                x.add(a.getDescription());
                x.add(a.getUrl());
                x.add(a.getPublishedAt());
                x.add(a.getAuthor());
                countryArticles.add(x);
            }
            // articleInfo
            countriesArticles.add(countryArticles);
            // totalResults
            totalResults.add(articleFactory.getTotalResults());
        }

        TopNewsOutputData topNewsOutputData = new TopNewsOutputData(countriesArticles, totalResults);
        topNewsOutputPresenter.prepareSuccessView(topNewsOutputData);
    }
}
