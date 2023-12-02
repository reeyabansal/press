package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class OpeningScreen extends JFrame implements ActionListener {
    public String viewName = "openingScreen";
    private JFrame app;
    private JPanel home;

    JLabel title, description;
    JButton loginBtn, createAccBtn;

    public OpeningScreen() {
        app = new JFrame();
        home = new JPanel();
        Color color = new Color(110, 188, 219);


        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(1200, 800);
        app.setLocationRelativeTo(null);
        app.setLayout(null);


        title = new JLabel("PRESS");
        title.setBounds(420, 300, 400, 100);
        title.setFont(new Font("Verdana", Font.BOLD, 100));
        title.setForeground(color);

        description = new JLabel("stay updated, stay notified, stay relevant.");
        description.setBounds(400, 380, 500, 100);
        description.setFont(new Font("Verdana", Font.PLAIN, 20));
        description.setForeground(Color.darkGray);

        loginBtn = new JButton("Log-in");
        loginBtn.setBounds(420, 460, 170, 40);
        loginBtn.setFont(Font.getFont("Verdana"));
        loginBtn.addActionListener(this);

        createAccBtn = new JButton("Sign-up");
        createAccBtn.setBounds(610, 460, 170, 40);
        createAccBtn.setFont(Font.getFont("Verdana"));
        createAccBtn.addActionListener(this);


        app.add(title);
        app.add(description);
        // app.add(loginBtn);
        app.add(createAccBtn);
        app.getContentPane().setBackground(Color.white);


        app.setTitle("Press");
        app.setVisible(true);

        createAccBtn.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent evt) {

    }

    /*public static void main(String[] args) throws IOException {
        new OpeningScreen();

    }*/

    /*@Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == createAccBtn) {
            new SignupScreen();
            app.dispose();

        }

        if (evt.getSource() == loginBtn) {
            new LoginScreen();
            app.dispose();

        }

    }*/
}
