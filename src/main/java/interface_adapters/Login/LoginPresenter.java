package interface_adapters.Login;

import interface_adapters.LoggedIn.LoggedInState;
import interface_adapters.LoggedIn.LoggedInViewModel;
import interface_adapters.TopNews.TopNewsState;
import interface_adapters.TopNews.TopNewsViewModel;
import interface_adapters.ViewManagerModel;
import use_case.LogIn.LoginOutputBoundary;
import use_case.LogIn.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          LoggedInViewModel loggedInViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the logged in view.

        LoggedInState loggedInState = loggedInViewModel.getState();
        // TODO: we give the top news model the email:
        // loggedInState.setEmail(response.getEmail());
        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setEmailError(error);
        loginViewModel.firePropertyChanged();
    }
}
