package view;


import interface_adapters.LoggedIn.LoggedInState;
import interface_adapters.LoggedIn.LoggedInViewModel;
import interface_adapters.login.LoginController;
import interface_adapters.login.LoginState;
import interface_adapters.login.LoginViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginScreen extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "log in";
    private final LoginViewModel loginViewModel;
    private final LoggedInViewModel loggedInViewModel;

    final JTextField usernameInputField = new JTextField(15);
    private final JLabel usernameErrorField = new JLabel();

    final JPasswordField passwordInputField = new JPasswordField(15);
    private final JLabel passwordErrorField = new JLabel();

    JLabel title1, description;


    final JButton logIn;
    final JButton cancel;
    private final LoginController loginController;

    public LoginScreen(LoginViewModel loginViewModel, LoginController controller, LoggedInViewModel loggedInViewModel) {

        this.loginController = controller;
        this.loginViewModel = loginViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.loginViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), passwordInputField);

        JPanel buttons = new JPanel();
        logIn = new JButton(loginViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(logIn);
        cancel = new JButton(loginViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        logIn.addActionListener(                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(logIn)) {
                            LoginState currentState = loginViewModel.getState();

                            loginController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword()
                            );
                            LoggedInState loggedInState = loggedInViewModel.getState();
                            loggedInState.setUsername(currentState.getUsername());
                            loggedInViewModel.setState(loggedInState);
                        }
                    }
                }
        );

        cancel.addActionListener(this);

        usernameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                LoginState currentState = loginViewModel.getState();
                currentState.setUsername(usernameInputField.getText() + e.getKeyChar());
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

        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        LoginState currentState = loginViewModel.getState();
                        currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
                        loginViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        title1 = new JLabel("PRESS");
        title1.setFont(new Font("Verdana", Font.BOLD, 60));
        Color color = new Color(110, 188, 219);
        title1.setForeground(color);
        title1.setAlignmentX(Component.CENTER_ALIGNMENT);

        description = new JLabel("stay updated, stay notified, stay relevant.");
        description.setFont(new Font("Verdana", Font.PLAIN, 10));
        description.setForeground(Color.darkGray);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title1);
        this.add(description);
        this.setBackground(Color.white);
        buttons.setBackground(Color.white);
        this.add(usernameInfo);
        this.add(usernameErrorField);
        this.add(passwordInfo);
        this.add(passwordErrorField);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoginState state = (LoginState) evt.getNewValue();
        setFields(state);
        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setUsername(state.getUsername());
        loggedInViewModel.setState(loggedInState);
    }

    private void setFields(LoginState state) {
        usernameInputField.setText(state.getUsername());
    }
}