package data_access;

import java.util.List;

public interface NewsAPITemplateDataAccessObject {
    List<com.kwabenaberko.newsapilib.models.Article> getData(String parameter, int number);
    boolean isReady();
}
