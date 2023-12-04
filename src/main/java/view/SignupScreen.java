package view;
import interface_adapters.Signup.SignupController;
import interface_adapters.Signup.SignupState;
import interface_adapters.Signup.SignupViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.io.IOException;

public class SignupScreen extends JFrame implements ActionListener {

    public final String viewName = "sign up";

    private final SignupViewModel signupViewModel;
    private final SignupController signupController;

    private JPasswordField passwordField, repeatPasswordField;
    private JTextField emailField;
    private JLabel label_password, label_email, label_repeatPass, message, title;
    private JButton signUpBtn, logInBtn;
    private JFrame app;
    private JPanel home;


    public SignupScreen(SignupController signupController, SignupViewModel signupViewModel) {

        this.signupController = signupController;
        this.signupViewModel = signupViewModel;

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

        signUpBtn.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(signUpBtn)) {
                            SignupState currentState = signupViewModel.getState();

                            signupController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword(),
                                    currentState.getRepeatPassword()
                            );
                        }
                    }
                }
        );

        emailField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        String text = emailField.getText() + e.getKeyChar();
                        currentState.setEmail(text);
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        passwordField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setPassword(passwordField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        repeatPasswordField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setRepeatPassword(repeatPasswordField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState); // Hmm, is this necessary?
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );


    }

    @Override
    public void actionPerformed(ActionEvent evt) {

    }


    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }

}
