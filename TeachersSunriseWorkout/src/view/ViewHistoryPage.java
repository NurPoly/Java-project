package view;

import javax.swing.*;
import java.awt.*;

public class ViewHistoryPage extends JPanel {
    private MainApp mainApp;

    public ViewHistoryPage(MainApp mainApp) {
        this.mainApp = mainApp;

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("View History & Track", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel historyPanel = new JPanel();
        historyPanel.setLayout(new GridLayout(0, 1));

        // Add history data here
        historyPanel.add(new JLabel("History data goes here"));

        JScrollPane scrollPane = new JScrollPane(historyPanel);
        add(scrollPane, BorderLayout.CENTER);
    }
}
