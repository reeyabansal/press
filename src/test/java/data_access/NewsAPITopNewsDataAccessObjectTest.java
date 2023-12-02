package data_access;

import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsAPITopNewsDataAccessObjectTest {
    private static ArticleResponse response = null;
    @BeforeAll
    static void init() throws InterruptedException {
        NewsAPIDataAccessObject dataAccessObject = new NewsAPITopNewsDataAccessObject();
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

    @Test
    void unsupported() throws InterruptedException {
        try {
            NewsAPIDataAccessObject dataAccessObject = new NewsAPITopNewsDataAccessObject();
            dataAccessObject.getData("qqkjwe");
            Thread.sleep(4000);
            response = dataAccessObject.getData();
            fail("Should have thrown exception for invalid country name.");
        }
        catch (IllegalArgumentException e) {
            assert(true);
        }

    }
}