import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;


class CreateSignupForm extends JFrame implements ActionListener
{
    JButton submitBtn;
    JButton loginBtn;
    JPanel newPanel;
    JLabel userLabel, passLabel, repeatPassLabel;
    final JTextField  textField1, textField2, textField3;

    //calling constructor
    CreateSignupForm()
    {

        userLabel = new JLabel();
        userLabel.setText("Username");

        textField1 = new JTextField(15);

        passLabel = new JLabel();
        passLabel.setText("Password");

        textField2 = new JPasswordField(15);

        repeatPassLabel = new JLabel();
        repeatPassLabel.setText("Repeat Password");

        textField3 = new JPasswordField(15);

        submitBtn = new JButton("Submit");
        loginBtn = new JButton("Sign Up");


        //create panel to put form elements
        newPanel = new JPanel(new GridLayout(4, 1));
        newPanel.add(userLabel);
        newPanel.add(textField1);
        newPanel.add(passLabel);
        newPanel.add(textField2);
        newPanel.add(repeatPassLabel);
        newPanel.add(textField3);
        newPanel.add(submitBtn);
        newPanel.add(loginBtn);

        add(newPanel, BorderLayout.CENTER);

        //perform action on button click
        submitBtn.addActionListener(this);
        setTitle("Login Form");
    }

    public void actionPerformed(ActionEvent ae)
    {
        String userValue = textField1.getText();
        String passValue = textField2.getText();

        //check whether the credentials are authentic or not
        if (userValue.equals("test1@gmail.com") && passValue.equals("test")) {

            //create instance of the next page
//            HomeScreen page = new HomeScreen();
//
//            //make page visible to the user
//            page.setVisible(true);
//
        }
        else{
            //show error message
            System.out.println("Please enter valid username and password");
        }
    }
}
//create the main class
class SignupFormMain
{
    //main() method start
    public static void main(String arg[])
    {
        try
        {
            //create instance of the CreateLoginForm
            CreateSignupForm form = new CreateSignupForm();
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