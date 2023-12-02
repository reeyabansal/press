package data_access;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

public class NewsAPIKeywordDataAccessObject implements NewsAPIDataAccessObject {
    private final NewsApiClient newsApiClient;
    private ArticleResponse data;

    public ArticleResponse getData() {
        return data;
    }
    public NewsAPIKeywordDataAccessObject() {
        String API_KEY = System.getenv("API_KEY");
        newsApiClient = new NewsApiClient(API_KEY);
        data = null;
    }

    @Override
    public ArticleResponse getData(String keyword) {
        data = null;
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q(keyword)
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        data = response;
                    }
                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );
        return data;
    }

    @Override
    public boolean isReady() {
        return data != null;
    }
}
