package entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TopNewsArticleFactoryTest {

    private static List<Article> articleList = null;
    private static List<Object> computedData = null;
    @BeforeAll
    static void init() throws InterruptedException {
        ArticleFactoryTemplate articleFactory = new TopNewsArticleFactory("United States");
        articleList = articleFactory.createArticles(5);
        computedData = articleFactory.getComputedData();
    }
    @Test
    void createArticles() {
        assert(articleList != null);
        assert(articleList.size() == 5);
        for(Article a: articleList) {
            System.out.println(a.getTitle());
        }
    }

    @Test
    void computeData() {
        assert(computedData.size() == 1);
        assert(computedData.get(0) instanceof Integer);
    }

    @Test
    void testGlobal() throws InterruptedException {
        ArticleFactoryTemplate articleFactory2 = new TopNewsArticleFactory("Global");
        articleFactory2.createArticles(5);
        assert(articleList != null);
        for(Article a: articleList) {
            System.out.println(a.getTitle());
        }
    }

    @Test
    void testUnsupported() throws InterruptedException {
        try {
            ArticleFactoryTemplate articleFactory2 = new TopNewsArticleFactory("qerqr");
            articleFactory2.createArticles(1);
            fail("Should have thrown exception for invalid country name.");
        } catch (IllegalArgumentException e) {
            assert(true);
        }

    }
}