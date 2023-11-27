package interface_adapters.Search;

import interface_adapters.ViewManagerModel;
import use_case.Search.SearchOutputBoundary;
import use_case.Search.SearchOutputData;

import java.util.List;

public class SearchPresenter implements SearchOutputBoundary {
    private final SearchViewModel searchViewModel;
    private final ViewManagerModel viewManagerModel;

    public SearchPresenter(SearchViewModel searchViewModel, ViewManagerModel viewManagerModel) {
        this.searchViewModel = searchViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    @Override
    public void prepareView(SearchOutputData searchOutputData) {
        // Title, ImageURL, Description, URL, PublishedAt, Author
        // Gets the current viewModel state, updates it, and sets it again, then fires a property change
        List<List<String>> articles = searchOutputData.getArticles();
        SearchState searchState = searchViewModel.getState();
        this.searchViewModel.setState(searchState);
        searchViewModel.firePropertyChanged();

        // Fires a property change for the viewManagerModel
        viewManagerModel.setActiveViewName(searchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
