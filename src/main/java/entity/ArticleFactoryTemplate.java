package entity;

import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import data_access.NewsAPIDataAccessObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class ArticleFactoryTemplate {
    protected String parameter;
    protected NewsAPIDataAccessObject dataAccessObject;
    protected List<Article> articleList;
    protected ArticleResponse responseData;
    protected List<Object> computedData;
    public abstract void fetchData();
    private List<Article> assembleArticles(int number) {
        List<Article> tempArticles = new ArrayList<>();
        List<com.kwabenaberko.newsapilib.models.Article> retrieved = responseData.getArticles();
        int limit;
        if (number == -1) limit = retrieved.size();
        else limit = Math.min(number, retrieved.size());
        for(int i = 0; i < limit; i++) {
            Article toAdd = new CommonArticle(
                    retrieved.get(i).getTitle(),
                    retrieved.get(i).getUrl(),
                    retrieved.get(i).getUrlToImage(),
                    retrieved.get(i).getSource().getLanguage(),
                    retrieved.get(i).getSource().getCountry(),
                    retrieved.get(i).getDescription(),
                    retrieved.get(i).getAuthor(),
                    retrieved.get(i).getSource().getId(),
                    retrieved.get(i).getPublishedAt(),
                    new Date()
            );

            tempArticles.add(toAdd);
        }

        articleList = tempArticles;
        return articleList;
    }
    public abstract void computeData();

    public List<Article> createArticles(int number) throws InterruptedException {

        fetchData();
        // wait for the asynchronous call to respond
        while(!dataAccessObject.isReady()) {
            Thread.sleep(30);
            responseData = dataAccessObject.getData();
        }
        responseData = dataAccessObject.getData();

        computedData = new ArrayList<>();
        computeData();
        articleList = assembleArticles(number);
        return articleList;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public List<Object> getComputedData() {
        return computedData;
    }
}
