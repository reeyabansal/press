package use_case.Search;

public class SearchInputData {
    private final String countryName;

    /**
     *
     * @param countryName
     *
     */
    public SearchInputData(String countryName) {
        this.countryName = countryName;
    }

    /**
     *
     * @return countryName
     * Getter method for keywordAttribute
     */
    public String getCountryName() {
        return countryName;
    }
}
