package entity;
import java.util.Date;

public class CommonArticle implements Article {
    private String title;

    private final String url;
    private final String imageUrl;
    private final String language;
    private final String country;
    private String description;
    private String author;
    private final String newsSource;
    private final String publishedAt;
    private final Date created;

    /**
     * @param title the title of the article
     * @param url the url to access the article
     * @param imageUrl the url of the image for this article provided by the API; null if no image found.
     * @param language the language the article is written in
     * @param country the main country the news source operates in
     * @param description a short description of the article
     * @param author the author of the article
     * @param newsSource the name of the news source publishing the article
     * @param publishedAt the time the article was published
     * @param created the time the article was created
     */
    public CommonArticle(String title, String url, String imageUrl, String language,
                         String country, String description, String author, String newsSource,
                         String publishedAt, Date created) {
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
        this.language = language;
        this.country = country;
        this.description = description;
        this.author = author;
        this.newsSource = newsSource;
        this.publishedAt = publishedAt;
        this.created = created;
    }

    @Override
    public String getTitle() {
        if (title != null) {
            int titleLength = title.length();
            for (int i = 0; i < titleLength; i++) {
                if (title.charAt(i) == ',') {
                    title = title.replace(",", " ");
                }
            }
        }

        return title;
    }

    @Override
    public String getUrl() {
        return url;
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
        if (description != null) {
            int descriptionLength = description.length();
            for (int i = 0; i < descriptionLength; i++) {
                if (description.charAt(i) == ',') {
                    description = description.replace(",", " ");
                }
            }
        }
        return description;
    }
    @Override
    public String getAuthor() {
        if (author != null) {
            int authorLength = author.length();
            for (int i = 0; i < authorLength; i++) {
                if (author.charAt(i) == ',') {
                    author = author.replace(",", " ");
                }
            }
        }
        return author;
    }

    @Override
    public String getNewsSource() {
        return newsSource;
    }

    @Override
    public String getPublishedAt() {
        return publishedAt;
    }

    @Override
    public Date getCreated() {
        return created;
    }
}
