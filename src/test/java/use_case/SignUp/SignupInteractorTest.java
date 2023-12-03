package use_case.SignUp;

import data_access.InMemoryUserDataAccessObject;
import entity.CommonUserFactory;
import entity.User;
import entity.UserFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignupInteractorTest {
    class DummyOutputBoundary implements SignupOutputBoundary {
        String error = null;
        SignupOutputData data = null;
        @Override
        public void prepareSuccessView(SignupOutputData user) {
            data = user;
        }

        @Override
        public void prepareFailView(String error) {
            this.error = error;
        }
    }

    @Test
    void execute() {
        DummyOutputBoundary outputBoundary = new DummyOutputBoundary();
        SignupUserDataAccessInterface dao = new InMemoryUserDataAccessObject();
        UserFactory factory = new CommonUserFactory();
        SignupInteractor interactor = new SignupInteractor(dao, outputBoundary, factory);

        // tests success
        interactor.execute(new SignupInputData("test727@gmail.com", "a", "a"));
        assert(dao.existsbyEmail("test727@gmail.com"));
        assert(outputBoundary.data.getEmail().equals("test727@gmail.com"));
        assert(dao.get("test727@gmail.com").getPassword().equals("a"));

        // tests fail by exists
        interactor.execute(new SignupInputData("user1@gmail.com", "a", "a"));
        interactor.execute(new SignupInputData("user1@gmail.com", "b", "b"));
        assert(outputBoundary.error.equals("User already exists."));

        // tests fail by password mismatch
        interactor.execute(new SignupInputData("user2@gmail.com", "aqoen", "a"));
        assert(outputBoundary.error.equals("Passwords don't match."));
    }

}