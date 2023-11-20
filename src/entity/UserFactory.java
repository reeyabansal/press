package entity;

import java.util.ArrayList;

public class UserFactory {
    public User create(String name, String email, String password, ArrayList<String> userHistory) {
        return new User(name, email, password, userHistory);
    }

}
