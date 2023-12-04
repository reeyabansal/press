package use_case.login;

import entity.CommonUserFactory;
import entity.User;
import entity.UserFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

class LoginInteractorTest {
    class DummyLoginDAO implements LoginUserDataAccessInterface {
        private final Map<String, User> users = new HashMap<>();
        DummyLoginDAO() {
            // initialize with a user
            UserFactory factory = new CommonUserFactory();
            users.put("user1", factory.create("user1","pass1", LocalDateTime.now()));
        }


        @Override
        public boolean existsByEmail(String identifier) {
            return false;
        }

        @Override
        public boolean existsByName(String identifier) {
            return users.containsKey(identifier);
        }

        @Override
        public void save(User user) {
            users.put(user.getName(), user);
        }

        @Override
        public User get(String email) {
            return users.get(email);
        }
    }

    class DummyOutputBoundary implements LoginOutputBoundary {
        String error = null;
        LoginOutputData data = null;

        @Override
        public void prepareSuccessView(LoginOutputData outputData) {
            data = outputData;
        }

        @Override
        public void prepareFailView(String error) {
            this.error = error;
        }
    }

    @Test
    void execute() {
        DummyLoginDAO loginDAO = new DummyLoginDAO();
        DummyOutputBoundary outputBoundary = new DummyOutputBoundary();
        LoginInteractor interactor = new LoginInteractor(loginDAO, outputBoundary);

        // test success
        interactor.execute(new LoginInputData("user1", "pass1"));
        assert(outputBoundary.data.getUsername().equals("user1"));

        // test fail by not exists
        interactor.execute(new LoginInputData("user2", "pass1"));
        assert(outputBoundary.error.equals("user2: Account does not exist."));

        // test fail by incorrect password
        interactor.execute(new LoginInputData("user1", "pass727"));
        assert(outputBoundary.error.equals("Incorrect password for user1."));
    }
}