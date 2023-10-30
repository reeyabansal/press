import com.kwabenaberko.newsapilib.*;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import com.kwabenaberko.newsapilib.models.request.SourcesRequest;
import com.kwabenaberko.newsapilib.models.response.SourcesResponse;
public class sample_api_call {
    public static void main(String[] args) {
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
    }
}
