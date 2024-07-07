package gymmanagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GymManagerGUI {
    private MyGymManager manager;
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;

    public GymManagerGUI(MyGymManager manager) {
        this.manager = manager;
        frame = new JFrame("Gym Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        tableModel = new DefaultTableModel(new Object[]{"Membership ID", "Member Type", "Start Date", "Member Name"}, 0);
        table = new JTable(tableModel);

        JButton addButton = new JButton("Add Member");
        JButton deleteButton = new JButton("Delete Member");
        JButton loadButton = new JButton("Load Members");
        JButton saveButton = new JButton("Save Members");
        JButton sortButton = new JButton("Sort Members");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMember();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteMember();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.loadMembers();
                refreshTable();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.saveMembers();
            }
        });

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.sortMembers();
                refreshTable();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 5));
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(loadButton);
        panel.add(saveButton);
        panel.add(sortButton);

        frame.getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
        frame.getContentPane().add(panel, BorderLayout.SOUTH);

        frame.setVisible(true);
        refreshTable();
    }

    private void addMember() {
        String[] options = {"Default Member", "Student Member", "Over 60 Member"};
        int memberType = JOptionPane.showOptionDialog(frame, "Select member type", "Add Member",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (memberType == -1) return;

        String membershipNumber = JOptionPane.showInputDialog("Enter membership number:");
        String memberName = JOptionPane.showInputDialog("Enter member name:");
        int day = Integer.parseInt(JOptionPane.showInputDialog("Enter start date day:"));
        int month = Integer.parseInt(JOptionPane.showInputDialog("Enter start date month:"));
        int year = Integer.parseInt(JOptionPane.showInputDialog("Enter start date year:"));
        Date startDate = new Date(day, month, year);

        DefaultMember member = null;
        switch (memberType) {
            case 0:
                member = new DefaultMember(membershipNumber, memberName, startDate);
                break;
            case 1:
                String schoolName = JOptionPane.showInputDialog("Enter school name:");
                member = new StudentMember(membershipNumber, memberName, startDate, schoolName);
                break;
            case 2:
                int age = Integer.parseInt(JOptionPane.showInputDialog("Enter age:"));
                member = new Over60Member(membershipNumber, memberName, startDate, age);
                break;
        }

        if (member != null) {
            manager.addMember(member);
            refreshTable();
        }
    }

    private void deleteMember() {
        String membershipNumber = JOptionPane.showInputDialog("Enter membership number to delete:");
        manager.deleteMember(membershipNumber);
        refreshTable();
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (DefaultMember member : manager.getMembers()) {
            String memberType = member instanceof StudentMember ? "Student Member"
                    : member instanceof Over60Member ? "Over 60 Member" : "Default Member";
            tableModel.addRow(new Object[]{member.getMembershipNumber(), memberType,
                    member.getStartMembershipDate(), member.getMemberName()});
        }
    }

    public static void main(String[] args) {
        MyGymManager manager = new MyGymManager();
        new GymManagerGUI(manager);
    }
}

