package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExerciseWorkoutPage extends JPanel {
    private MainApp mainApp;
    private JLabel timerLabel;
    private Timer timer;
    private int duration;

    public ExerciseWorkoutPage(MainApp mainApp) {
        this.mainApp = mainApp;

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Workout", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        timerLabel = new JLabel("00:00", JLabel.CENTER);
        timerLabel.setFont(new Font("Serif", Font.BOLD, 48));
        add(timerLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));

        JButton startButton = new JButton("Start Timer");
        JButton finishButton = new JButton("Finish Workout");

        buttonPanel.add(startButton);
        buttonPanel.add(finishButton);

        add(buttonPanel, BorderLayout.SOUTH);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTimer();
            }
        });

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopTimer();
                mainApp.showPage("HomePage");
            }
        });
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            int timeLeft = duration;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeLeft > 0) {
                    timeLeft--;
                    timerLabel.setText(formatTime(timeLeft));
                } else {
                    ((Timer) e.getSource()).stop();
                    // Play sound
                    JOptionPane.showMessageDialog(mainApp, "Time's up!", "Timer", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        timer.start();
    }

    private void stopTimer() {
        if (timer != null) {
            timer.stop();
        }
    }

    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        int secs = seconds % 60;
        return String.format("%02d:%02d", minutes, secs);
    }
}

