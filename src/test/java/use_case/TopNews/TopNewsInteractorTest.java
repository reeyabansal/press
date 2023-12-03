package use_case.TopNews;

import org.junit.jupiter.api.Test;

class TopNewsInteractorTest {
     class DummyOutputBoundary implements TopNewsOutputBoundary {
        public TopNewsOutputData topNewsOutputData;
        DummyOutputBoundary() {
            topNewsOutputData = null;
        }

        public TopNewsOutputData getTopNewsOutputData() {
            return topNewsOutputData;
        }

        @Override
        public void prepareSuccessView(TopNewsOutputData topNewsOutputData) {
            this.topNewsOutputData = topNewsOutputData;
        }
    }

    @Test
    void execute() throws InterruptedException {
        DummyOutputBoundary dummy = new DummyOutputBoundary();
        TopNewsInputBoundary interactor = new TopNewsInteractor(dummy);
        interactor.execute(new TopNewsInputData());
        assert(dummy.getTopNewsOutputData() != null);
    }
}