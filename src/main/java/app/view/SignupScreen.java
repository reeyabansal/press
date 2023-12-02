package app.view;
import interface_adapters.Signup.SignupController;
import interface_adapters.Signup.SignupViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SignupScreen extends JFrame implements ActionListener {

    private JPasswordField passwordField, repeatPasswordField;
    private JTextField emailField;
    private JLabel label_password, label_email, label_repeatPass, message, title;
    private JButton signUpBtn, logInBtn;
    private JFrame app;
    private JPanel home;


    public SignupScreen() {
        app = new JFrame();
        home = new JPanel();
        // home.setLayout(new FlowLayout());


        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(1200, 800);
        app.setLocationRelativeTo(null);
        app.setLayout(null);

        label_email = new JLabel("Email");
        label_email.setBounds(380, 300, 100, 40);

        emailField = new JTextField();
        emailField.setBounds(500, 300, 300, 40);

        label_password = new JLabel("Password");
        label_password.setBounds(380, 350, 100, 40);

        passwordField = new JPasswordField();
        passwordField.setBounds(500, 350, 300, 40);

        label_repeatPass = new JLabel("Repeat Password");
        label_repeatPass.setBounds(380, 400, 200, 40);

        repeatPasswordField = new JPasswordField();
        repeatPasswordField.setBounds(500, 400, 300, 40);

        signUpBtn = new JButton("Create Account");
        signUpBtn.setBounds(500, 470, 120, 40);
        signUpBtn.addActionListener(this);

        logInBtn = new JButton("Log-in");
        logInBtn.setBounds(630, 470, 100, 40);
        logInBtn.addActionListener(this);

        app.add(label_email);
        app.add(emailField);
        app.add(passwordField);
        app.add(label_password);
        app.add(label_repeatPass);
        app.add(repeatPasswordField);
        app.add(signUpBtn);
        app.add(logInBtn);

        app.setTitle("Sign Up");
        // app.pack();
        app.setVisible(true);

    }

    public SignupScreen(SignupController signupController, SignupViewModel signupViewModel) {
    }

    public static void main(String[] args) throws IOException {
        new SignupScreen();

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == logInBtn) {
            new LoginScreen();
            app.dispose();

        }

        if (evt.getSource() == signUpBtn) {
            try {
                new HomeScreen();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            app.dispose();

        }

    }
}
