package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JPanel {
    private MainApp mainApp;

    public LoginPage(MainApp mainApp) {
        this.mainApp = mainApp;

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Teacher's Sunrise Workout", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel(""));
        loginPanel.add(loginButton);

        add(loginPanel, BorderLayout.CENTER);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (authenticate(username, password)) {
                    mainApp.showPage("HomePage");
                } else {
                    JOptionPane.showMessageDialog(mainApp, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private boolean authenticate(String username, String password) {
                // Replace this with actual authentication logic
                String[] validUsernames = {"PYP1", "PYP2", "PYP3", "PYP4", "PYP5", "MYP1", "MYP2", "MYP3", "MYP4", "MYP5", "DP1", "DP2"};
                for (String validUsername : validUsernames) {
                    if (validUsername.equals(username) && password.equals("4ourHealth")) {
                        return true;
                    }
                }
                return false;
            }
        });
    }
}
