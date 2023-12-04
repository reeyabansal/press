package use_case.LogIn;

import entity.User;

public class LoginInteractor implements LoginInputBoundary {
    final LoginUserDataAccessInterface userDataAccessObject;
    final LoginOutputBoundary loginPresenter;

    public LoginInteractor(LoginUserDataAccessInterface userDataAccessInterface,
                           LoginOutputBoundary loginOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }

    @Override
    public void execute(LoginInputData loginInputData) {
        String email = loginInputData.getEmail();
        String password = loginInputData.getPassword();
        if (!userDataAccessObject.existsByEmail(email)) {
            loginPresenter.prepareFailView(email + ": Account does not exist.");
        } else {
            String pwd = userDataAccessObject.get(email).getPassword();
            if (!password.equals(pwd)) {
                loginPresenter.prepareFailView("Incorrect password for " + email + ".");
            } else {

                User user = userDataAccessObject.get(loginInputData.getEmail());

                LoginOutputData loginOutputData = new LoginOutputData(user.getEmail(), false);
                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
    }
}