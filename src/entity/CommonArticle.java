package entity;
import java.util.Date;

public class CommonArticle implements Article {
    private final String title;
    private final String imageUrl;
    private final String language;
    private final String country;
    private final String description;
    private final String author;
    private final String newsSource;
    private final Date created;

    /**
     * @param title the title of the article
     * @param imageUrl the url of the image for this article provided by the API; null if no image found.
     * @param language the language the article is written in
     * @param country the main country the news source operates in
     * @param description a short description of the article
     * @param author the author of the title
     * @param newsSource the name of the news source publishing the article
     * @param created the time the article was created
     */
    public CommonArticle(String title, String imageUrl, String language,
                         String country, String description, String author, String newsSource, Date created) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.language = language;
        this.country = country;
        this.description = description;
        this.author = author;
        this.newsSource = newsSource;
        this.created = created;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String getLanguage() {
        return language;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getNewsSource() {
        return newsSource;
    }

    @Override
    public Date getCreated() {
        return created;
    }
}
