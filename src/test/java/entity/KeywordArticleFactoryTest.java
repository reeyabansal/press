package entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KeywordArticleFactoryTest {

    @Test
    void createArticles() throws InterruptedException {
        ArticleFactoryTemplate articleFactory = new KeywordArticleFactory("Canada");
        List<Article> articleList = articleFactory.createArticles(5);
        assert(articleList != null);
        assert(articleList.size() == 5);
        for(Article a: articleList) {
            System.out.println(a.getTitle());
            assert(a.getTitle().contains("Canada")) || a.getTitle().contains("Canadian");
        }
    }
}