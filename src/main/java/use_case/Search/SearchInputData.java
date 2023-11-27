package use_case.Search;

public class SearchInputData {
    private final String countryName;
    public SearchInputData(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}
