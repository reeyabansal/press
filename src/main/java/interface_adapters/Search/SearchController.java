package interface_adapters.Search;

import use_case.Search.SearchInputBoundary;
import use_case.Search.SearchInputData;

public class SearchController {
    final SearchInputBoundary searchInteractor;

    /**
     *
     * @param searchInteractor
     *
     */
    public SearchController(SearchInputBoundary searchInteractor) {

        this.searchInteractor = searchInteractor;
    }

    /**
     *
     * @param countryName
     *
     */
    public void execute(String countryName) throws InterruptedException {
        SearchInputData searchInputData = new SearchInputData(countryName);
        searchInteractor.execute(searchInputData);
    }
}
