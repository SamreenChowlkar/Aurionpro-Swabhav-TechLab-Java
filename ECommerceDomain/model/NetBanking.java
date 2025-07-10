package Com.Aurionpro.ECommerceDomain.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NetBanking implements IPaymentGateway {

    String username;
    String password;
    String bankName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            System.out.println("Invalid !! Username cannot be empty");
        } else {
            this.username = username;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 4) {
            System.out.println("Invalid !! Password should be at least 4 characters");
        } else {
            this.password = password;
        }
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        if (bankName == null || bankName.trim().isEmpty()) {
            System.out.println("Invalid !! Bank name cannot be empty");
        } else {
            this.bankName = bankName;
        }
    }

    public void display() {
        System.out.println("-----------------------------------------");
        System.out.println("Bank: " + getBankName());
        System.out.println("Username: " + getUsername());
    }

    @Override
    public void pay(double amount) {
        if (amount > 0) {
            System.out.println("Payment of ₹" + amount + " successful via NetBanking (" + bankName + ")");
        } else {
            System.out.println("Invalid payment amount.");
        }
    }

    @Override
    public void refund(double amount) {
        if (amount > 0) {
            System.out.println("Refund of ₹" + amount + " processed to NetBanking account (" + bankName + ")");
        } else {
            System.out.println("Invalid refund amount.");
        }
    }

    public void getInput() {
        try {
            Scanner scanner = new Scanner(System.in);

            // Username
            while (true) {
                System.out.println("Enter Username: ");
                String username = scanner.nextLine();
                setUsername(username);
                if (username != null && !username.trim().isEmpty()) break;
            }

            // Password
            while (true) {
                System.out.println("Enter Password (min 4 characters): ");
                String password = scanner.nextLine();
                setPassword(password);
                if (password != null && password.length() >= 4) break;
            }

            // Bank Name
            while (true) {
                System.out.println("Enter Bank Name: ");
                String bankName = scanner.nextLine();
                setBankName(bankName);
                if (bankName != null && !bankName.trim().isEmpty()) break;
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid details.");
        }
    }
}
