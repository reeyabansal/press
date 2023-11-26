package use_case.TopNews;

public interface TopNewsInputBoundary {
    void execute(TopNewsInputData topNewsInputData) throws InterruptedException;
}
