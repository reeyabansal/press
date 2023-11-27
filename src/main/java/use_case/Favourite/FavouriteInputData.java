package use_case.Favourite;

import java.util.List;

public class FavouriteInputData {
    final private List<String> article;
    final private String username;

    public FavouriteInputData(List<String> article, String username) {
        this.article = article;
        this.username = username;
    }

    public List<String> getArticle() {
        return article;
    }
}
