package data_access;

import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

public interface NewsAPIDataAccessObject {

    // should only be called after getData was called with a parameter
    ArticleResponse getData();
    ArticleResponse getData(String parameter);
    boolean isReady();
}
