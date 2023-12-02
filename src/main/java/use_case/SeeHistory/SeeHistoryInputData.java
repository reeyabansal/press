package use_case.SeeHistory;

public class SeeHistoryInputData {
    private final String username;
    public SeeHistoryInputData(String username) {
        this.username = username;
    }

    /**
     *
     * @return username
     * Getter method for username attribute
     */
    public String getUsername() {
        return username;
    }
}
