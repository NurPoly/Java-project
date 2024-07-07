package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JPanel {
    private MainApp mainApp;

    public HomePage(MainApp mainApp) {
        this.mainApp = mainApp;

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Welcome to Teacher's Sunrise Workout", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 1));

        JButton pushUpsButton = new JButton("1) Push Ups");
        JButton jumpingJacksButton = new JButton("2) Jumping Jacks");
        JButton squatsButton = new JButton("3) Squats");
        JButton manageExercisesButton = new JButton("Manage Exercises");
        JButton viewHistoryButton = new JButton("View History & Track");
        JButton logoutButton = new JButton("Log Out");

        buttonPanel.add(pushUpsButton);
        buttonPanel.add(jumpingJacksButton);
        buttonPanel.add(squatsButton);
        buttonPanel.add(manageExercisesButton);
        buttonPanel.add(viewHistoryButton);
        buttonPanel.add(logoutButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Add action listeners for buttons
        manageExercisesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showPage("ManageExercisesPage");
            }
        });

        viewHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showPage("ViewHistoryPage");
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showPage("LoginPage");
            }
        });

        // Add other button listeners similarly...
    }
}
