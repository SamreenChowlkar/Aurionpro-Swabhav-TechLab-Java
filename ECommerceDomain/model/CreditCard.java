package Com.Aurionpro.ECommerceDomain.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreditCard implements IPaymentGateway {

    String cardNumber;
    String CVV;
    int expiryMonth;
    int expiryYear;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        if (cardNumber.length() != 16) {
            System.out.println("Invalid !! The Card Number should be of 16 digits only");
        } else {
            this.cardNumber = cardNumber;
        }
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        if (CVV.length() != 3) {
            System.out.println("Invalid !! The CVV should be of 3 digits only");
        } else {
            this.CVV = CVV;
        }
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(int expiryMonth) {
        if (expiryMonth < 1 || expiryMonth > 12) {
            System.out.println("Invalid month");
        } else {
            this.expiryMonth = expiryMonth;
        }
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(int expiryYear) {
        if (expiryYear < 2025) {
            System.out.println("Invalid Year");
        } else {
            this.expiryYear = expiryYear;
        }
    }

    public void display() {
        System.out.println("-----------------------------------------");
        System.out.println("Card Number: " + getCardNumber());
        System.out.println("CVV: " + getCVV());
        System.out.println("Expiry date: " + getExpiryMonth() + "/" + getExpiryYear());
    }

    @Override
    public void pay(double amount) {
        if (amount > 0) {
            System.out.println("Payment of ₹" + amount + " successful using Credit Card ending with " + cardNumber.substring(12));
        } else {
            System.out.println("Invalid payment amount.");
        }
    }

    @Override
    public void refund(double amount) {
        if (amount > 0) {
            System.out.println("Refund of ₹" + amount + " processed to Credit Card ending with " + cardNumber.substring(12));
        } else {
            System.out.println("Invalid refund amount.");
        }
    }

    public void getInput() {
        try {
            Scanner scanner = new Scanner(System.in);

            // Card Number
            while (true) {
                System.out.println("Enter Card Number (16 digits): ");
                String cardNumber = scanner.next();
                setCardNumber(cardNumber);
                if (cardNumber.length() == 16) break;
            }

            // CVV
            while (true) {
                System.out.println("Enter CVV (3 digits): ");
                String CVV = scanner.next();
                setCVV(CVV);
                if (CVV.length() == 3) break;
            }

            // Expiry Month
            while (true) {
                System.out.println("Enter Expiry Month (1-12): ");
                if (scanner.hasNextInt()) {
                    int expiryMonth = scanner.nextInt();
                    setExpiryMonth(expiryMonth);
                    if (expiryMonth >= 1 && expiryMonth <= 12) break;
                } else {
                    System.out.println("Please enter a number.");
                    scanner.next(); // discard invalid input
                }
            }

            // Expiry Year
            while (true) {
                System.out.println("Enter Expiry Year (>=2025): ");
                if (scanner.hasNextInt()) {
                    int expiryYear = scanner.nextInt();
                    setExpiryYear(expiryYear);
                    if (expiryYear >= 2025) break;
                } else {
                    System.out.println("Please enter a number.");
                    scanner.next(); // discard invalid input
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Please Enter Only Valid Numbers");
        }
    }

}
