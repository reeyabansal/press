package interface_adapters.TopNews;

import interface_adapters.Map.MapState;
import interface_adapters.ViewManagerModel;
import use_case.TopNews.TopNewsOutputBoundary;
import use_case.TopNews.TopNewsOutputData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopNewsPresenter implements TopNewsOutputBoundary {
    private final TopNewsViewModel topNewsViewModel;
    private final ViewManagerModel viewManagerModel;

    public TopNewsPresenter(TopNewsViewModel topNewsViewModel, ViewManagerModel viewManagerModel) {
        this.topNewsViewModel = topNewsViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(TopNewsOutputData topNewsOutputData) {

        // Title, ImageURL, Description, URL, PublishedAt, Author
        // Gets the current viewModel state, updates it, and sets it again, then fires a property change
        List<List<String>> articleInfo = topNewsOutputData.getArticleInfo();

        TopNewsState topNewsState = topNewsViewModel.getState();
        topNewsState.setArticleInfo(articleInfo);

//        List<Integer> totalResults = topNewsOutputData.getTotalResults();
//        List<Integer> sizes = new ArrayList<>();
//        int max = Collections.max(totalResults);
//        int min = Collections.min(totalResults);
//        int maxCircleSize = 60;
//        int minCircleSize = 10;
//        for (int articles : totalResults) {
//            double radius = ((double) (articles - min) / (max - min)) *
//                    (maxCircleSize - minCircleSize) + minCircleSize;
//            sizes.add((int)radius);
//        }
//        System.out.println(totalResults);
//        System.out.println(sizes);
//        System.out.println(articleInfo);

//        topNewsState.setSizes(sizes);

        this.topNewsViewModel.setState(topNewsState);
        topNewsViewModel.firePropertyChanged();

        // Fires a property change for the viewManagerModel
        viewManagerModel.setActiveView(topNewsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
