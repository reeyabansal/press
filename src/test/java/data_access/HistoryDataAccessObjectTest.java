package data_access;

import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HistoryDataAccessObjectTest {

    private static List<List<String>> response = null;
    @BeforeAll
    static void init() throws IOException {
        HistoryDataAccessObject dataAccessObject = new HistoryDataAccessObject();
//        List<String> article = new ArrayList<>();
//        article.add("Headlines from Canada");
//        // username,title,imageUrl,description,url,publishedAt,author,visited_time
//        article.add("https.image_url");
//        article.add("description of article");
//        article.add("https.article_url");
//        article.add("2023-05-15");
//        article.add("Author 1");

//        dataAccessObject.addToHistory(article, "press");

        File csvFile = new File("./visited_articles");
        if (csvFile.length() > 1) {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))){
                String header = reader.readLine();
                String line = reader.readLine();
                String username = Arrays.asList(line.split(",")).get(0);
                response = dataAccessObject.getHistory(username);
            }
        }
        else {
            response = new ArrayList<>();
        }
    }

    @Test
    void getArticle() {
        assert response != null;
    }


}
