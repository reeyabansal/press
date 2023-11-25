package entity;

import java.util.ArrayList;

public class ArticleHistory {
    ArrayList<Article> articleHistory;
    // Front of the ArrayList (index 0) stores the most recent article visited
    public ArticleHistory() {
        articleHistory = new ArrayList<Article>();
    }

    public Article getMostRecentArticle() {
        return articleHistory.get(-1);
    }

    public Article getLeastRecentArticle() {
        return articleHistory.get(0);
    }

    public void updateArticleHistory(Article article) {
        if (articleHistory.size() == 15)
            articleHistory.remove(-1);
        articleHistory.add(0, article);
    }
}
