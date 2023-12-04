package app;

import view.SignupScreen;
import interface_adapters.Login.LoginViewModel;
import interface_adapters.Signup.SignupController;
import interface_adapters.Signup.SignupPresenter;
import interface_adapters.Signup.SignupViewModel;
import interface_adapters.ViewManagerModel;
import use_case.SignUp.SignupUserDataAccessInterface;
import entity.CommonUserFactory;
import entity.UserFactory;
import use_case.SignUp.SignupInputBoundary;
import use_case.SignUp.SignupInteractor;
import use_case.SignUp.SignupOutputBoundary;


import javax.swing.*;
import java.io.IOException;

public class SignupUseCaseFactory {

    /** Prevent instantiation. */
    private SignupUseCaseFactory() {}

    /**
     *
     * @param viewManagerModel
     * @param loginViewModel
     * @param signupViewModel
     * @param userDataAccessObject
     * @return
     */
    public static SignupScreen create(
            ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel, SignupUserDataAccessInterface userDataAccessObject) {

        try {
            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel, userDataAccessObject);
            return new SignupScreen(signupController, signupViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel, SignupUserDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);

        UserFactory userFactory = new CommonUserFactory();

        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        return new SignupController(userSignupInteractor);
    }
}
