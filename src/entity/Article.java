package entity;

import java.util.Date;

public interface Article {
    public String getTitle();

    public String getImageUrl();

    public String getLanguage();

    public String getCountry();

    public String getDescription();

    public String getAuthor();
    public String getNewsSource();

    public Date getCreated();
}