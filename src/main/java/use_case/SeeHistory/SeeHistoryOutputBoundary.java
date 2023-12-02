package use_case.SeeHistory;

public interface SeeHistoryOutputBoundary {
    void prepareFailView(String error);
    void prepareSuccessView(SeeHistoryOutputData seeHistoryOutputData);
}
