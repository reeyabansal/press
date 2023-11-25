package entity;

import java.util.List;

public interface ArticleFactory {

    List<Article> createArticles(String parameter, int n) throws InterruptedException;
}
