package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import model.Exercise;

public class ManageExercisesPage extends JPanel {
    private MainApp mainApp;
    private List<Exercise> exercises;

    public ManageExercisesPage(MainApp mainApp) {
        this.mainApp = mainApp;
        this.exercises = new ArrayList<>();

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Manage Your Exercises", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel exercisesPanel = new JPanel();
        exercisesPanel.setLayout(new GridLayout(0, 1));

        updateExercisesList(exercisesPanel);

        JScrollPane scrollPane = new JScrollPane(exercisesPanel);
        add(scrollPane, BorderLayout.CENTER);

        JPanel addEditPanel = new JPanel();
        addEditPanel.setLayout(new GridLayout(3, 2));

        JLabel exerciseNameLabel = new JLabel("Exercise Name:");
        JTextField exerciseNameField = new JTextField();
        JLabel durationLabel = new JLabel("Duration (seconds):");
        JTextField durationField = new JTextField();
        JButton addButton = new JButton("Add");

        addEditPanel.add(exerciseNameLabel);
        addEditPanel.add(exerciseNameField);
        addEditPanel.add(durationLabel);
        addEditPanel.add(durationField);
        addEditPanel.add(new JLabel(""));
        addEditPanel.add(addButton);

        add(addEditPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = exerciseNameField.getText();
                int duration = Integer.parseInt(durationField.getText());
                exercises.add(new Exercise(name, duration));
                updateExercisesList(exercisesPanel);
                mainApp.showPage("HomePage");
            }
        });
    }

    private void updateExercisesList(JPanel exercisesPanel) {
        exercisesPanel.removeAll();
        for (Exercise exercise : exercises) {
            exercisesPanel.add(new JLabel(exercise.getName() + " - " + exercise.getDuration() + " seconds"));
        }
        exercisesPanel.revalidate();
        exercisesPanel.repaint();
    }
}
