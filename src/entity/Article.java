package entity;
import java.util.Date;

public class Article {
    String title;
    String imageUrl;
    String language;
    String country;
    String description;
    String author;
    String newsSource;
    Date created;

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
    public Article(String title, String imageUrl, String language,
                   String country, String description, String author, String newsSource, Date created) {
        title = title;
        imageUrl = imageUrl;
        language = language;
        country = country;
        description = description;
        author = author;
        newsSource = newsSource;
        created = created;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getNewsSource() {
        return newsSource;
    }

    public Date getCreated() {
        return created;
    }
}
