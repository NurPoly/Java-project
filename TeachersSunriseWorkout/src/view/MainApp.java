package view;

import javax.swing.*;
import java.awt.*;


    public class MainApp extends JFrame {
        private CardLayout cardLayout;

        public MainApp() {
            setTitle("Teacher's Sunrise Workout");
            setSize(400, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            cardLayout = new CardLayout();
            setLayout(cardLayout);

            LoginPage loginPage = new LoginPage(this);
            HomePage homePage = new HomePage(this);
            ManageExercisesPage manageExercisesPage = new ManageExercisesPage(this);
            ExerciseWorkoutPage exerciseWorkoutPage = new ExerciseWorkoutPage(this);
            ViewHistoryPage viewHistoryPage = new ViewHistoryPage(this);

            add(loginPage, "LoginPage");
            add(homePage, "HomePage");
            add(manageExercisesPage, "ManageExercisesPage");
            add(exerciseWorkoutPage, "ExerciseWorkoutPage");
            add(viewHistoryPage, "ViewHistoryPage");

            cardLayout.show(getContentPane(), "LoginPage");
        }





        public void showPage(String pageName) {
            cardLayout.show(getContentPane(), pageName);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                MainApp app = new MainApp();
                app.setVisible(true);
            });
        }
    }

