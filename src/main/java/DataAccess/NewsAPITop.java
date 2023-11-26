package DataAccess;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

import entity.Article;
import entity.ArticleFactory;
import entity.CommonArticle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import use_case.TopNews.SUPPORTED_COUNTRIES;

public class NewsAPITop implements ArticleFactory {
    private final NewsApiClient newsApiClient;
    private final Map<String, String> supportedCountries = SUPPORTED_COUNTRIES.getSupportedCountries();
    private List<Article> articleList;
    private int totalResults;
    public NewsAPITop () {
        String API_KEY = System.getenv("API_KEY");
        newsApiClient = new NewsApiClient(API_KEY);
        articleList = new ArrayList<>();
    }

    /**
     * Creates n "top headlines" from the given country. If the number of requested
     * articles exceeds the limit provided by NewsApi, the maximum number of articles is
     * provided instead. If the country is not in the list of supported countries
     * for the map, null is returned.
     * @param country the country to have articles sourced from
     * @param number  the number of articles to create; negative one if it should be all of them
     */
    @Override
    public List<Article> createArticles(String country, int number) throws InterruptedException {

        // check if country is supported
        boolean supported = false;
        for(String s : supportedCountries.keySet()) {
            if(s.equals(country)) {
                supported = true;
                break;
            }
        }

        // if supported, continue with the API call
        if (supported) {
            newsApiClient.getTopHeadlines(
                    new TopHeadlinesRequest.Builder()
                            .country(supportedCountries.get(country))
                            .pageSize(100)
                            .build(),
                    new NewsApiClient.ArticlesResponseCallback() {
                        @Override
                        public void onSuccess(ArticleResponse response) {
                            totalResults = response.getTotalResults();
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
            Thread.sleep(2000);
            return articleList;
        }
        else {
            System.out.println("not supported");
            return null;
        }
    }

    public int getTotalResults() {
        return totalResults;
    }
}
