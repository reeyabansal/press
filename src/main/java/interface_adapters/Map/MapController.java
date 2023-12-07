package interface_adapters.Map;

import use_case.Map.MapInputBoundary;
import use_case.Map.MapInputData;

public class MapController {
    final MapInputBoundary mapInteractor;
    /**
     * @param mapInputBoundary
     */

    public MapController(MapInputBoundary mapInputBoundary) {
        this.mapInteractor = mapInputBoundary;
    }
    /**
     * @param countryName
     */

    public void execute(String countryName) throws InterruptedException {
        MapInputData mapInputData = new MapInputData(countryName);

        mapInteractor.execute(mapInputData);
    }
}
