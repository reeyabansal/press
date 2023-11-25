package interface_adapters.Map;

import use_case.Map.MapInputBoundary;
import use_case.Map.MapInputData;

public class MapController {
    final MapInputBoundary mapInteractor;

    public MapController(MapInputBoundary mapInputBoundar) {
        this.mapInteractor = mapInputBoundar;
    }

    public void execute(String countryName) {
        MapInputData mapInputData = new MapInputData(countryName);

        mapInteractor.execute(mapInputData);
    }
}
