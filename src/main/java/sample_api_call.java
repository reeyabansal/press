import data_access.NewsAPITop;
import com.kwabenaberko.newsapilib.*;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import com.kwabenaberko.newsapilib.models.request.SourcesRequest;
import com.kwabenaberko.newsapilib.models.response.SourcesResponse;

import java.util.List;
import data_access.NewsAPICountry;
import entity.Article;

public class sample_api_call {
    public static void main(String[] args) throws InterruptedException {

        // instantiate the factory class
        NewsAPICountry c = new NewsAPICountry();

        // create two articles about canada and store them
        List<Article> articles = c.createArticles("Canada", 2);

        // can also get the articles later
        List<Article> articles2 = c.getArticleList();

        // do operations with them
        System.out.println(articles.get(0).getTitle());
        System.out.println(c);
        System.out.print(articles);
        System.out.println(articles.size());
        System.out.println(articles.get(0).getUrl());

        System.out.println("newsapitop");
        NewsAPITop d = new NewsAPITop();
        List<Article> top = d.createArticles("Canada", 2);
        System.out.println(top.get(0).getTitle());
        System.out.println(d.getTotalResults());

        top = d.createArticles("China", 3);
        System.out.println(top.get(0).getTitle());
        System.out.println(d.getTotalResults());

        // example API calls with the NewsApiClient directly
        // IMPORTANT: set environment variable with API_KEY=YOUR_API_KEY_HERE in run configurations
        // and replace YOUR_API_KEY_HERE with your api key (similar to the grade api example from lab)
        String API_KEY = System.getenv("API_KEY");

        NewsApiClient newsApiClient = new NewsApiClient(API_KEY);
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q("Israel")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        System.out.println(response.getArticles().get(0).getUrl());
                        System.out.println(response.getArticles().get(0).getUrlToImage());
                        System.out.println(response.getArticles().get(0).getDescription());
                        System.out.println(response.getArticles().get(0).getContent());
                        System.out.println(response.getArticles().toArray().length);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );

        newsApiClient.getSources(
                new SourcesRequest.Builder()
                        .language("en")
                        .country("us")
                        .build(),
                new NewsApiClient.SourcesCallback() {
                    @Override
                    public void onSuccess(SourcesResponse response) {
                        System.out.println(response.getSources().get(0).getName());
                        System.out.println(response.getSources().toArray().length);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );

        System.out.println("top headlines");
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .country("us")
                        .pageSize(20)
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        for(int i = 0; i < Math.min(5, response.getTotalResults()); i++) {
                            System.out.println(response.getArticles().get(i).getUrl());
                        }

                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );

    }
}
