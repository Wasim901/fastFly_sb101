package com.masai.system.UI;

import java.util.Scanner;

import com.masai.system.DAO.AdminDao;
import com.masai.system.DAO.AdminDaoImp;
import com.masai.system.DTO.Admin;

public class AdminConsole {

    private static final Scanner scanner = new Scanner(System.in);
    private static final AdminDao adminDao = new AdminDaoImp();

    public static void main(String[] args) {
        System.out.println("Welcome to the Admin Console!");
        adminMenu();
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Admin");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addAdmin();
                    break;
                case 2:
                    System.out.println("Exiting Admin Console...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int getUserChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return choice;
    }

    private static void addAdmin() {
        System.out.println("\nAdd Admin:");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Admin newAdmin = new Admin(username, password);
        adminDao.addAdmin(newAdmin);

        System.out.println("Admin added successfully!");
    }

}