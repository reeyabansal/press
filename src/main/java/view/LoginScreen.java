package view;
import interface_adapters.Login.LoginController;
import interface_adapters.Login.LoginState;
import interface_adapters.Login.LoginViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.io.IOException;

public class LoginScreen extends JFrame implements ActionListener {

    public final String viewName = "log in";
    private final LoginViewModel loginViewModel;

    private final LoginController loginController;

    private JPasswordField passwordField;
    private JTextField emailField;
    private JLabel label_password, label_email, message, title;
    private JButton signUpBtn, logInBtn;
    private JFrame app;
    private JPanel home;


    public LoginScreen(LoginViewModel loginViewModel, LoginController loginController) {

        this.loginController = loginController;
        this.loginViewModel = loginViewModel;

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

        /*logInBtn = new JButton("Log-in");
        logInBtn.setBounds(500, 420, 100, 40);
        logInBtn.addActionListener(this);*/


        app.add(label_email);
        app.add(emailField);
        app.add(passwordField);
        app.add(label_password);
        app.add(signUpBtn);
        app.add(logInBtn);

        app.setTitle("Sign Up");
        // app.pack();
        app.setVisible(true);

        logInBtn.addActionListener(                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(logInBtn)) {
                            LoginState currentState = loginViewModel.getState();

                            loginController.execute(
                                    currentState.getEmail(),
                                    currentState.getPassword()
                            );
                        }
                    }
                }
        );

        emailField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                LoginState currentState = loginViewModel.getState();
                currentState.setEmail(emailField.getText() + e.getKeyChar());
                loginViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        passwordField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        LoginState currentState = loginViewModel.getState();
                        currentState.setPassword(passwordField.getText() + e.getKeyChar());
                        loginViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

    }


    @Override
    public void actionPerformed(ActionEvent evt) {

    }

    public void propertyChange(PropertyChangeEvent evt) {
        LoginState state = (LoginState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(LoginState state) {
        emailField.setText(state.getEmail());
    }
}
