package use_case.SeeHistory;

import java.util.List;

public class SeeHistoryOutputData {
    private final List<List<String>> visited;
    public SeeHistoryOutputData(List<List<String>> visited) {
        this.visited = visited;
    }

    /**
     *
     * @return visited
     * Getter method for visited attribute
     */
    public List<List<String>> getVisited() {
        return visited;
    }
}
