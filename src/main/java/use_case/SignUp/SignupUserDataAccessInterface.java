package use_case.SignUp;

import entity.User;

public interface SignupUserDataAccessInterface {
    boolean existsbyEmail(String identifier);

    void save(User user);
}
