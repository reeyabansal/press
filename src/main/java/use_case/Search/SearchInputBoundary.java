package use_case.Search;

public interface SearchInputBoundary {
    void execute(SearchInputData searchInputData) throws InterruptedException;
}

