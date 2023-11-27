package use_case.Favourite;

import java.util.List;

public class FavouriteInputData {
    final private List<String> article;

    public FavouriteInputData(List<String> article) {
        this.article = article;
    }

    public List<String> getArticle() {
        return article;
    }
}
