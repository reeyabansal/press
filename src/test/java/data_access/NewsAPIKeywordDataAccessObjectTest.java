package data_access;

import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class NewsAPIKeywordDataAccessObjectTest {
    private static ArticleResponse response = null;
    @BeforeAll
    static void init() throws InterruptedException {
        NewsAPIDataAccessObject dataAccessObject = new NewsAPIKeywordDataAccessObject();
        dataAccessObject.getData("Canada");
        Thread.sleep(4000);
        response = dataAccessObject.getData();
    }

    @Test
    void getData() {
        assert(response != null);
    }

    @Test
    void isReady() {
        assert(response != null);
    }
}