package entity;

import java.util.ArrayList;

public class User {

    private final String name;
    private final String email;
    private final String password;
    private ArrayList<String> userHistory;

    /**
     * @param name name of the user
     * @param email email of the user
     * @param password password of the user
     * @param userHistory last 10 articles viewed by the user
     */


    User(String name, String email, String password, ArrayList<String> userHistory) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userHistory = userHistory;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getUserHistory() {
        return userHistory;
    }

}
