package entity;

public class PasswordValidator {
    public boolean isPasswordValid(String password) {
        return password != null && password.length() >= 4;
    }
}
