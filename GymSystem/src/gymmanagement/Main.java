package gymmanagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyGymManager manager = new MyGymManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Add Member");
            System.out.println("2. Delete Member");
            System.out.println("3. Print Members");
            System.out.println("4. Sort Members");
            System.out.println("5. Save Members");
            System.out.println("6. Load Members");
            System.out.println("7. Open GUI");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter member type (1: Default, 2: Student, 3: Over60): ");
                    int type = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Enter membership number: ");
                    String membershipNumber = scanner.nextLine();
                    System.out.println("Enter member name: ");
                    String memberName = scanner.nextLine();
                    System.out.println("Enter start date (day month year): ");
                    int day = scanner.nextInt();
                    int month = scanner.nextInt();
                    int year = scanner.nextInt();
                    Date startDate = new Date(day, month, year);

                    if (type == 1) {
                        manager.addMember(new DefaultMember(membershipNumber, memberName, startDate));
                    } else if (type == 2) {
                        System.out.println("Enter school name: ");
                        String schoolName = scanner.next();
                        manager.addMember(new StudentMember(membershipNumber, memberName, startDate, schoolName));
                    } else if (type == 3) {
                        System.out.println("Enter age: ");
                        int age = scanner.nextInt();
                        manager.addMember(new Over60Member(membershipNumber, memberName, startDate, age));
                    }
                    break;
                case 2:
                    System.out.println("Enter membership number to delete: ");
                    String deleteNumber = scanner.nextLine();
                    manager.deleteMember(deleteNumber);
                    break;
                case 3:
                    manager.printMembers();
                    break;
                case 4:
                    manager.sortMembers();
                    break;
                case 5:
                    manager.saveMembers();
                    break;
                case 6:
                    manager.loadMembers();
                    break;
                case 7:
                    // Launch GUI (to be implemented)
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}

