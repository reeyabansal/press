package interface_adapters.Login;

import use_case.LogIn.LoginInputBoundary;
import use_case.LogIn.LoginInputData;

public class LoginController {

    final LoginInputBoundary loginUseCaseInteractor;
    public LoginController(LoginInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }


    public void execute(String email, String password) {
        LoginInputData loginInputData = new LoginInputData(
                email, password);

        loginUseCaseInteractor.execute(loginInputData);
    }
}
