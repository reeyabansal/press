package data_access;

import entity.Article;
import use_case.Favourite.FavouriteDataAccessInterface;
import use_case.SeeFavourites.SeeFavouritesDataAccessInterface;

import java.io.*;
import java.util.*;

public class FavouriteDataAccessObject implements FavouriteDataAccessInterface, SeeFavouritesDataAccessInterface {
    private final String csvPath = "/assets/data/favourite_articles.csv";
    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final List<List<String>> favourites = new ArrayList<>();

    public FavouriteDataAccessObject() throws IOException {
        csvFile = new File(csvPath);

        headers.put("username", 0);
        headers.put("title", 1);
        headers.put("imageUrl", 2);
        headers.put("description", 3);
        headers.put("url", 4);
        headers.put("publishedAt", 5);
        headers.put("author", 6);

        if (csvFile.length() == 0) {
            save();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("username,password,creation_time");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
//                    String username = String.valueOf(col[headers.get("username")]);
//                    String title = String.valueOf(col[headers.get("title")]);
//                    String imageUrl = String.valueOf(col[headers.get("imageUrl")]);
//                    String description = String.valueOf(col[headers.get("description")]);
//                    String url = String.valueOf(col[headers.get("url")]);
//                    String publishedAt = String.valueOf(col[headers.get("publishedAt")]);
//                    String author = String.valueOf(col[headers.get("author")]);

                    favourites.add(List.of(col));
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
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

            for (List<String> articleDetails: favourites) {
                String line = String.format("%s,%s,%s,%s,%s,%s,%s",
                        articleDetails.get(0), articleDetails.get(1), articleDetails.get(2), articleDetails.get(3),
                        articleDetails.get(4), articleDetails.get(5), articleDetails.get(6));
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addFavourite(List<String> article, String username) {
        List<String> fullDetails = new ArrayList<>();
        fullDetails.add(username);
        fullDetails.addAll(article);
        favourites.add(fullDetails);
        this.save();
    }

    public List<List<String>> getFavourites(String username) {
        // Returns [[Title, ImageURL, Description, URL, PublishedAt, Author], ...]
        List<List<String>> favouriteArticles = new ArrayList<>();
        for (List<String> articleDetails: favourites) {
            if (articleDetails.get(0).equals(username)) {
                favouriteArticles.add(articleDetails.subList(1, articleDetails.size()));
            }
        }
        return favouriteArticles;
    }
}
