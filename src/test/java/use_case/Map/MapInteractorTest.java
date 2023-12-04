package use_case.Map;

import org.junit.jupiter.api.Test;
import use_case.Search.*;

import static org.junit.jupiter.api.Assertions.*;

class MapInteractorTest {
    class DummyOutputBoundary implements MapOutputBoundary {
        public MapOutputData mapOutputData;
        DummyOutputBoundary() {
            mapOutputData = null;
        }

        public MapOutputData getSearchOutputData() {
            return mapOutputData;
        }

        @Override
        public void prepareView(MapOutputData mapOutputData) {
            this.mapOutputData = mapOutputData;
        }
    }

    @Test
    void execute() throws InterruptedException {
        DummyOutputBoundary dummy = new DummyOutputBoundary();
        MapInteractor interactor = new MapInteractor(dummy);
        interactor.execute(new MapInputData("Canada"));
        assert(dummy.getSearchOutputData() != null);
    }
}