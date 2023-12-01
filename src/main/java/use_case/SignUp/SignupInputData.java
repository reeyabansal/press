package use_case.SignUp;

public class SignupInputData {

    final private String email;
    final private String password;
    final private String repeatPassword;

    public SignupInputData(String email, String password, String repeatPassword) {
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    String getEmail() {
        return email;
    }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}
