package use_case.Search;

import org.junit.jupiter.api.Test;
import use_case.TopNews.*;

import static org.junit.jupiter.api.Assertions.*;

class SearchInteractorTest {
    class DummyOutputBoundary implements SearchOutputBoundary {
        public SearchOutputData searchOutputData;
        DummyOutputBoundary() {
            searchOutputData = null;
        }

        public SearchOutputData getSearchOutputData() {
            return searchOutputData;
        }

        @Override
        public void prepareView(SearchOutputData searchOutputData) {
            this.searchOutputData = searchOutputData;
        }
    }

    @Test
    void execute() throws InterruptedException {
        DummyOutputBoundary dummy = new DummyOutputBoundary();
        SearchInteractor interactor = new SearchInteractor(dummy);
        interactor.execute(new SearchInputData("Canada"));
        assert(dummy.getSearchOutputData() != null);
    }
}