import com.kwabenaberko.newsapilib.*;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import com.kwabenaberko.newsapilib.models.request.SourcesRequest;
import com.kwabenaberko.newsapilib.models.response.SourcesResponse;
public class test {
    public static void main(String[] args) {
        NewsApiClient newsApiClient = new NewsApiClient("1271b25519b64342802765dd7aa7b8f2");

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
