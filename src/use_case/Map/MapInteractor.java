package use_case.Map;

import entity.CommonArticle;

import java.util.ArrayList;

public class MapInteractor implements MapInputBoundary{
    final MapOutputBoundary mapPresenter;
    public MapInteractor(MapOutputBoundary mapOutputBoundary){
        this.mapPresenter = mapOutputBoundary;
    }

    public void execute(MapInputData mapInputData) {
        // TODO: write API call that gets all the articles for countryName. Store them as article objects and create
        //  an ArrayList of Article objects to create MapOutputData
        MapOutputData mapOutputData = new MapOutputData(new ArrayList<CommonArticle>());
        mapPresenter.prepareView(mapOutputData);
    }
}
