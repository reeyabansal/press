package use_case.SeeHistory;

import java.util.List;

public class SeeHistoryOutputData {
    private final List<List<String>> visited;
    public SeeHistoryOutputData(List<List<String>> visited) {
        this.visited = visited;
    }

    public List<List<String>> getVisited() {
        return visited;
    }
}
