package view;

import data_access.InMemoryUserDataAccessObject;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapters.signup.SignupController;
import interface_adapters.signup.SignupPresenter;
import interface_adapters.signup.SignupViewModel;
import org.junit.jupiter.api.Test;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;
import use_case.signup.SignupUserDataAccessInterface;

import static org.junit.jupiter.api.Assertions.*;

class SignupScreenTest {
    class DummyOutput implements SignupOutputBoundary {

        @Override
        public void prepareSuccessView(SignupOutputData user) {

        }

        @Override
        public void prepareFailView(String error) {

        }
    }

    @Test
    void constructor() {
        SignupUserDataAccessInterface dataAccessInterface = new InMemoryUserDataAccessObject();
        SignupOutputBoundary outputBoundary = new DummyOutput();
        UserFactory userFactory = new CommonUserFactory();
        SignupController signupController = new SignupController(new SignupInteractor(dataAccessInterface, outputBoundary, userFactory));
        SignupScreen signupScreen = new SignupScreen(signupController, new SignupViewModel());
    }

}