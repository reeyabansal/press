package data_access;

import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import entity.Article;
import entity.ArticleFactory;
import com.kwabenaberko.newsapilib.*;
import entity.CommonArticle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A class used to create articles about a given country.
 */
public class NewsAPICountry implements ArticleFactory {
    private final NewsApiClient newsApiClient;
    private List<Article> articleList;

    public List<Article> getArticleList() {
        return articleList;
    }

    public NewsAPICountry() {
        String API_KEY = System.getenv("API_KEY");
        newsApiClient = new NewsApiClient(API_KEY);
        articleList = new ArrayList<>();
    }

    /**
     * Creates n articles that mention the given country. If the number of requested
     * articles exceeds the limit provided by NewsApi, the maximum number of articles is
     * provided instead.
     *
     * @param country the country to have articles sourced from
     * @param number  the number of articles to create; negative one if it should be all of them
     */
    @Override
    public List<Article> createArticles(String country, final int number) throws InterruptedException {
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q(country)
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        List<Article> tempArticles = new ArrayList<>();

                        List<com.kwabenaberko.newsapilib.models.Article> retrieved = response.getArticles();
                        int limit;
                        if (number == -1) limit = retrieved.size();
                        else limit = Math.min(number, retrieved.size());
                        for(int i = 0; i < limit; i++) {
                            Article toAdd = new CommonArticle(
                                    retrieved.get(i).getTitle(),
                                    retrieved.get(i).getUrl(),
                                    retrieved.get(i).getUrlToImage(),
                                    retrieved.get(i).getSource().getLanguage(),
                                    retrieved.get(i).getSource().getCountry(),
                                    retrieved.get(i).getDescription(),
                                    retrieved.get(i).getAuthor(),
                                    retrieved.get(i).getSource().getId(),
                                    retrieved.get(i).getPublishedAt(),
                                    new Date()
                            );

                            tempArticles.add(toAdd);
                        }

                        articleList = tempArticles;
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );

//      Need to pause execution because onSuccess is called asynchronously, so we wait a few seconds to
//      ensure it has been called
//      later, will implement this with the observer pattern to continue once it updates
        // wait until callback
        // update viewmodel and property change
        // while true loop
        // wait a couple seconds as well
        // while(not returned): wait
        // may need to decide where this lives can maybe use observer / listener pattern and property changed.
//        List<Article> articles2 = c.articleList;
//        System.out.println(c.test);

        Thread.sleep(2000);
        return articleList;
    }
}
