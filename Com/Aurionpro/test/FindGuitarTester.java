package Com.Aurionpro.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import Com.Aurionpro.model.Builder;
import Com.Aurionpro.model.GuitarBuilderUI;
import Com.Aurionpro.model.GuitarSpec;
import Com.Aurionpro.model.Inventory;
import Com.Aurionpro.model.Type;
import Com.Aurionpro.model.Wood;

public class FindGuitarTester {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        // Initialize pre-defined guitars
        initializeInventory(inventory);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Guitar Inventory System ---");
            System.out.println("1. Add Guitar\n2. View All Guitars\n3. Search Guitars\n4. Delete Guitar\n5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> GuitarBuilderUI.addGuitar(scanner, inventory);
                    case 2 -> GuitarBuilderUI.viewGuitars(inventory.getAllGuitars());
                    case 3 -> GuitarBuilderUI.searchGuitar(scanner, inventory);
                    case 4 -> {
                        System.out.print("Enter Serial Number to delete: ");
                        String serial = scanner.nextLine();
                        if (inventory.deleteGuitar(serial))
                            System.out.println("Deleted successfully.");
                        else
                            System.out.println("Guitar not found.");
                    }
                    case 5 -> {
                        exit = true;
                        System.out.println("Exiting...");
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                scanner.nextLine(); // clear invalid input
            }
        }

        scanner.close();
    }

    private static void initializeInventory(Inventory inventory) {
        inventory.addGuitar("11277", 3999.95, new GuitarSpec(
                Builder.COLLINGS, "CJ", Type.ACOUSTIC, Wood.MAPLE, 6));
        
        inventory.addGuitar("V95693", 1499.95, new GuitarSpec(
                Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, 6));
        
        inventory.addGuitar("V9512", 1549.95, new GuitarSpec(
               Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, 6));
        
        inventory.addGuitar("122784", 5495.95, new GuitarSpec(
                Builder.MARTIN, "D-18", Type.ACOUSTIC, Wood.MAPLE, 6));
    }
}
