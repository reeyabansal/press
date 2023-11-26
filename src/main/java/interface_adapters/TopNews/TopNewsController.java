package interface_adapters.TopNews;

import use_case.TopNews.TopNewsInputBoundary;
import use_case.TopNews.TopNewsInputData;

public class TopNewsController {
    final TopNewsInputBoundary topNewsInteractor;
    public TopNewsController(TopNewsInputBoundary topNewsInputBoundary) {
        this.topNewsInteractor = topNewsInputBoundary;
    }
    public void execute() throws InterruptedException {
        TopNewsInputData topNewsInputData = new TopNewsInputData();
        topNewsInteractor.execute(topNewsInputData);
    }
}
