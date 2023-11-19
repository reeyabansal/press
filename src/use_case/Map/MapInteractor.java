package use_case.Map;

import entity.CommonArticle;

import java.util.ArrayList;

public class MapInteractor implements MapInputBoundary{
    final MapOutputBoundary mapPresenter;
    public MapInteractor(MapOutputBoundary mapOutputBoundary){
        this.mapPresenter = mapOutputBoundary;
    }

    public void execute(MapInputData mapInputData) {
        // TODO: write API call
        MapOutputData mapOutputData = new MapOutputData(new ArrayList<CommonArticle>());
        mapPresenter.prepareView(mapOutputData);
    }
}
