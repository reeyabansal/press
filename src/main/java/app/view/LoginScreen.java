package app.view;
import interface_adapters.Login.LoginController;
import interface_adapters.Login.LoginViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginScreen extends JFrame implements ActionListener {

    private JPasswordField passwordField;
    private JTextField emailField;
    private JLabel label_password, label_email, message, title;
    private JButton signUpBtn, logInBtn;
    private JFrame app;
    private JPanel home;


    public LoginScreen() {
        app = new JFrame();
        home = new JPanel();
        // home.setLayout(new FlowLayout());


        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(1200, 800);
        app.setLocationRelativeTo(null);
        app.setLayout(null);

        label_email = new JLabel("Email");
        label_email.setBounds(400, 300, 100, 40);

        emailField = new JTextField();
        emailField.setBounds(500, 300, 300, 40);

        label_password = new JLabel("Password");
        label_password.setBounds(400, 350, 100, 40);

        passwordField = new JPasswordField();
        passwordField.setBounds(500, 350, 300, 40);

        passwordField = new JPasswordField();
        passwordField.setBounds(500, 350, 300, 40);

        signUpBtn = new JButton("Create Account");
        signUpBtn.setBounds(610, 420, 120, 40);
        signUpBtn.addActionListener(this);

        logInBtn = new JButton("Log-in");
        logInBtn.setBounds(500, 420, 100, 40);
        logInBtn.addActionListener(this);


        app.add(label_email);
        app.add(emailField);
        app.add(passwordField);
        app.add(label_password);
        app.add(signUpBtn);
        app.add(logInBtn);

        app.setTitle("Sign Up");
        // app.pack();
        app.setVisible(true);

    }

    public LoginScreen(LoginViewModel loginViewModel, LoginController loginController) {

    }

    public static void main(String[] args) throws IOException {
        new LoginScreen();

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == signUpBtn) {
            new SignupScreen();
            app.dispose();

        }

        if (evt.getSource() == logInBtn) {
            new HomeScreen();
            app.dispose();

        }
    }
}
