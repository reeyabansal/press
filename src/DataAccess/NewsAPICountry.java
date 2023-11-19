package DataAccess;

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
    private NewsApiClient newsApiClient;
    public NewsAPICountry() {
        String API_KEY = System.getenv("API_KEY");
        NewsApiClient newsApiClient = new NewsApiClient(API_KEY);
    }

    /**
     * Creates n articles that are about the given country. If the number of requested
     * articles exceeds the limit provided by NewsApi, the maximum number of articles is
     * provided instead
     * @param country the country to have articles sourced from
     * @param number the number of articles to create; negative one if it should be all of them
     * @return a list with n articles sourced from the given country
     */
    @Override
    public List<Article> createArticles(String country, final int number) {
        List<Article> articles = new ArrayList<>();
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q(country)
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
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
                            articles.add(toAdd);
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );

        return articles;
    }
}
