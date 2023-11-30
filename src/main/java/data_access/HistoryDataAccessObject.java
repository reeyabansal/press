package data_access;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HistoryDataAccessObject {
    private final String csv_file = "/assets/data/visited_articles.csv";
    public HistoryDataAccessObject(){

    }

    public List<List<String>> getHistory(String username) {
        List<List<String>> articlesHistory = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csv_file))){
            String header = reader.readLine();
            String line = reader.readLine();
            // Loop finds the line where the user
            while (line != null) {
                ArrayList<String> lineArticleData = new ArrayList<>(Arrays.asList(line.split(",")));
                if (Objects.equals(lineArticleData.get(0), username)) {
                    break;
                }
                line = reader.readLine();
            }

            // Loops over lines till another user's data is reached
            assert line != null;
            ArrayList<String> userArticleData = new ArrayList<>(Arrays.asList(line.split(",")));
            while (line != null && Objects.equals(userArticleData.get(0), username)) {
                articlesHistory.add(userArticleData.subList(1,userArticleData.size()));
                line = reader.readLine();
                userArticleData = new ArrayList<>(Arrays.asList(line.split(",")));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return articlesHistory;
    }

    public void updateHistory(String username, List<String> article){
        
    }

}
