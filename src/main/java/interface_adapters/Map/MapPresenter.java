package interface_adapters.Map;

import interface_adapters.ViewManagerModel;
import use_case.Map.MapOutputBoundary;
import use_case.Map.MapOutputData;

import java.util.List;

public class MapPresenter implements MapOutputBoundary {
    private final MapViewModel mapViewModel;
    private final ViewManagerModel viewManagerModel;

    public MapPresenter(MapViewModel mapViewModel, ViewManagerModel viewManagerModel) {
        this.mapViewModel = mapViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareView(MapOutputData mapOutputData) {
        // Title, ImageURL, Description, URL, PublishedAt, Author
        // Gets the current viewModel state, updates it, and sets it again, then fires a property change
        List<List<String>> articles = mapOutputData.getArticles();
        MapState mapState = mapViewModel.getState();
        mapState.setArticles(articles);
        this.mapViewModel.setState(mapState);
        mapViewModel.firePropertyChanged();

        // Fires a property change for the viewManagerModel
        viewManagerModel.setActiveViewName(mapViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
