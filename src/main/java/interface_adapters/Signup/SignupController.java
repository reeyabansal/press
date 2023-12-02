package interface_adapters.Signup;

import use_case.SignUp.SignupInputBoundary;
import use_case.SignUp.SignupInputData;

public class SignupController {

    final SignupInputBoundary userSignupUseCaseInteractor;
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void execute(String email, String password1, String password2) {
        SignupInputData signupInputData = new SignupInputData(
                email, password1, password2);

        userSignupUseCaseInteractor.execute(signupInputData);
    }
}
