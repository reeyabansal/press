package data_access;

import use_case.History.HistoryDataAccessInterface;
import use_case.SeeHistory.SeeHistoryDataAccessInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.io.*;
import java.util.*;

public class HistoryDataAccessObject implements HistoryDataAccessInterface, SeeHistoryDataAccessInterface {
    private final String csvPath = "/assets/data/visited_articles.csv";
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final List<List<String>> visited = new ArrayList<>();


    public HistoryDataAccessObject() {
        csvFile = new File(csvPath);

        headers.put("username", 0);
        headers.put("title", 1);
        headers.put("imageUrl", 2);
        headers.put("description", 3);
        headers.put("url", 4);
        headers.put("publishedAt", 5);
        headers.put("author", 6);
        headers.put("visited_time", 7);

        if (csvFile.length() == 0) {
            save();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
//                assert header.equals("username,password,creation_time");
                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    visited.add(List.of(col));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (List<String> articleDetails: visited) {
                String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                        articleDetails.get(0), articleDetails.get(1), articleDetails.get(2), articleDetails.get(3),
                        articleDetails.get(4), articleDetails.get(5), articleDetails.get(6), articleDetails.get(7));
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addToHistory(List<String> article, String username) {
        List<String> fullDetails = new ArrayList<>();
        fullDetails.add(username);
        fullDetails.addAll(article);
        fullDetails.add(String.valueOf(LocalDateTime.now()));
        visited.add(fullDetails);
        this.save();
    }

    public List<List<String>> getHistory(String username) {
        List<List<String>> visitedArticles = new ArrayList<>();
        for (List<String> articleDetails : visited) {
            if (articleDetails.get(0).equals(username)) {
                visitedArticles.add(articleDetails.subList(1,7));
            }
        }
        return visitedArticles;
    }
}

