package use_case.Search;

public interface SearchInputBoundary {

    /**
     * @param searchInputData */
    void execute(SearchInputData searchInputData) throws InterruptedException;
}

