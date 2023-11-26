package use_case.TopNews;

import entity.Article;

import java.util.List;

public class TopNewsOutputData {

    // Our program's supported countries
    private final List<String> supportedCountries = SUPPORTED_COUNTRIES.getSupportedCountriesList();
    // A list of lists of strings where each list of strings corresponds to an article,
    // the list of lists of strings represents a list of articles, and the list of lists of articles has
    // one list of articles for a country in supportedCountries in the same order they appear
    private List<List<List<String>>> articleInfo;

    // A list of integers representing the number of articles published in the last month.
    // The integers are in the same order as supportedCountries.
    private List<Integer> totalResults;
    TopNewsOutputData(List<List<List<String>>> articleInfo, List<Integer> totalResults) {
        this.articleInfo = articleInfo;
        this.totalResults = totalResults;
    }

    public List<List<List<String>>> getArticleInfo() {
        return articleInfo;
    }

    public List<Integer> getTotalResults() {
        return totalResults;
    }
}
