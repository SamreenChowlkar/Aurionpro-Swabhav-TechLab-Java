package Com.Aurionpro.ECommerceDomain.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import Com.Aurionpro.ECommerceDomain.model.CreditCard;
import Com.Aurionpro.ECommerceDomain.model.NetBanking;
import Com.Aurionpro.ECommerceDomain.model.UPIPayment;

public class CheckoutTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CreditCard credit = new CreditCard();
        NetBanking netBanking = new NetBanking();
        UPIPayment upi = new UPIPayment();

        while (true) {
            try {
                System.out.println("\n--- Select Payment Method ---");
                System.out.println("1. Credit Card");
                System.out.println("2. Net Banking");
                System.out.println("3. UPI");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume leftover newline

                switch (choice) {
                    case 1:
                        credit.getInput();
                        credit.display();
                        processPayment(scanner, credit);
                        break;

                    case 2:
                        netBanking.getInput();
                        netBanking.display();
                        processPayment(scanner, netBanking);
                        break;

                    case 3:
                        upi.getInput();
                        upi.display();
                        processPayment(scanner, upi);
                        break;

                    case 4:
                        System.out.println("Thank you for using our service!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please select from 1 to 4.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numeric values only.");
                scanner.nextLine(); // clear invalid input
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static void processPayment(Scanner scanner, Com.Aurionpro.ECommerceDomain.model.IPaymentGateway payment) {
        try {
            System.out.print("Enter amount to pay: ");
            double amount = scanner.nextDouble();
            payment.pay(amount);

            scanner.nextLine(); // clear newline
            System.out.print("Do you want to request a refund? (yes/no): ");
            String refundChoice = scanner.nextLine();

            if (refundChoice.equalsIgnoreCase("yes")) {
            	payment.refund(amount);
            }

        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number for the amount.");
            scanner.nextLine(); // clear invalid input
        }
    }
}
