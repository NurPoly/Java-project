package com.atm;
import java.util.Scanner;
public class main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int balance= 1000;
        int choice;
        while(true){
            System.out.println("ATM Menu:");
            System.out.println("1.Check Balance:");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Current Balance: " + balance);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    int deposit = scanner.nextInt();
                    balance += deposit;
                    System.out.println("Amount deposited. New Balance: " + balance);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    int withdraw = scanner.nextInt();
                    if (withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println("Amount withdrawn. New Balance: " + balance);
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;
                case 4:
                    System.out.println("Exiting... Thank you for using the ATM!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        }
    }

