import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;


class CreateLoginForm extends JFrame implements ActionListener
{
    JButton submitBtn;
    JButton signUpBtn;
    JPanel newPanel;
    JLabel userLabel, passLabel;
    final JTextField  textField1, textField2;

    //calling constructor
    CreateLoginForm()
    {

        userLabel = new JLabel();
        userLabel.setText("Username");

        textField1 = new JTextField(15);

        passLabel = new JLabel();
        passLabel.setText("Password");

        textField2 = new JPasswordField(15);

        submitBtn = new JButton("Submit");
        signUpBtn = new JButton("Sign Up");


        //create panel to put form elements
        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(userLabel);
        newPanel.add(textField1);
        newPanel.add(passLabel);
        newPanel.add(textField2);
        newPanel.add(submitBtn);
        newPanel.add(signUpBtn);

        add(newPanel, BorderLayout.CENTER);

        //perform action on button click
        submitBtn.addActionListener(this);
        setTitle("Login Form");
    }

    public void actionPerformed(ActionEvent ae)
    {
        String userValue = textField1.getText();
        String passValue = textField2.getText();

        CreateSignupForm form = new CreateSignupForm();
        form.setSize(300,100);  //set size of the frame
        form.setVisible(true);  //make form visible to the user
    }
}
//create the main class
class LoginFormMain
{
    //main() method start
    public static void main(String arg[])
    {
        try
        {
            //create instance of the CreateLoginForm
            CreateLoginForm form = new CreateLoginForm();
            form.setSize(300,100);  //set size of the frame
            form.setVisible(true);  //make form visible to the user
        }
        catch(Exception e)
        {
            //handle exception
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}