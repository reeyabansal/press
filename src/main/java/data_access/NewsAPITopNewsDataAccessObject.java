package data_access;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import use_case.TopNews.SUPPORTED_COUNTRIES;

import java.util.Map;

public class NewsAPITopNewsDataAccessObject implements NewsAPIDataAccessObject {

    private final NewsApiClient newsApiClient;
    private final Map<String, String> supportedCountries = SUPPORTED_COUNTRIES.getSupportedCountries();
    private ArticleResponse data = null;

    public ArticleResponse getData() {
        return data;
    }
    public NewsAPITopNewsDataAccessObject() {
        String API_KEY = System.getenv("API_KEY");
        newsApiClient = new NewsApiClient(API_KEY);
    }
    @Override
    public ArticleResponse getData(String parameter) {
        // check if country is supported
        // null represents global
        boolean supported = false;
        if(parameter == null || parameter.equals("Global")) {
            parameter = "Global";
            supported = true;
        }
        else {
            for(String s : supportedCountries.keySet()) {
                if(s.equals(parameter)) {
                    supported = true;
                    break;
                }
            }
        }

        // if supported, continue with the API call
        if (supported) {
            String country;
            if (parameter.equals("Global")) country = null;
            else country = supportedCountries.get(parameter);
            System.out.println("supported:" + country);
            newsApiClient.getTopHeadlines(
                    new TopHeadlinesRequest.Builder()
                            .country(country)
                            .language("en")
                            .pageSize(100)
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
        else {
            throw new IllegalArgumentException("Not recognized or not supported parameter input.");
        }
    }

    @Override
    public boolean isReady() {
        return data != null;
    }
}
