package entity;

import java.util.List;

public interface ArticleFactory {

    List<Article> createArticles(int n) throws InterruptedException;
    public List<Article> getArticleList();

    public List<Object> getComputedData();
}
