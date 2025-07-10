package Com.Aurionpro.ECommerceDomain.model;

import java.util.Scanner;

public class UPIPayment implements IPaymentGateway {

    String upiId;
    String upiPin;

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        if (upiId == null || !upiId.contains("@") || upiId.trim().isEmpty()) {
            System.out.println("Invalid !! UPI ID must be in format like 'name@bank'");
        } else {
            this.upiId = upiId;
        }
    }

    public String getUpiPin() {
        return upiPin;
    }

    public void setUpiPin(String upiPin) {
        if (upiPin == null || !upiPin.matches("\\d{4,6}")) {
            System.out.println("Invalid !! UPI PIN must be 4 to 6 digits");
        } else {
            this.upiPin = upiPin;
        }
    }

    public void display() {
        System.out.println("-----------------------------------------");
        System.out.println("UPI ID: " + getUpiId());
    }

    @Override
    public void pay(double amount) {
        if (amount > 0) {
            System.out.println("Payment of ₹" + amount + " successful using UPI ID: " + upiId);
        } else {
            System.out.println("Invalid payment amount.");
        }
    }

    @Override
    public void refund(double amount) {
        if (amount > 0) {
            System.out.println("Refund of ₹" + amount + " processed to UPI ID: " + upiId);
        } else {
            System.out.println("Invalid refund amount.");
        }
    }

    public void getInput() {
        Scanner scanner = new Scanner(System.in);

        // UPI ID
        while (true) {
            System.out.println("Enter UPI ID (e.g. name@bank): ");
            String inputUpi = scanner.nextLine();
            setUpiId(inputUpi);
            if (inputUpi != null && inputUpi.contains("@") && !inputUpi.trim().isEmpty()) break;
        }

        // UPI PIN
        while (true) {
            System.out.println("Enter UPI PIN (4-6 digit number): ");
            String inputPin = scanner.nextLine();
            setUpiPin(inputPin);
            if (inputPin != null && inputPin.matches("\\d{4,6}")) break;
        }
    }
}
