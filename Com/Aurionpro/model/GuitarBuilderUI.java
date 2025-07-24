package Com.Aurionpro.model;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GuitarBuilderUI {

	public static void addGuitar(Scanner scanner, Inventory inventory) {
	    System.out.println("\n--- Customize Your Guitar ---");

	    Builder builder = selectEnum(scanner, Builder.values(), "Builder");
	    Type type = selectEnum(scanner, Type.values(), "Type");
	    Wood wood = selectEnum(scanner, Wood.values(), "Wood");

	    scanner.nextLine(); // Consume leftover newline
	    System.out.print("Enter Model Name: ");
	    String model = scanner.nextLine();

	    int numStrings;
	    while (true) {
	        numStrings = getIntInput(scanner, "Enter number of strings (6 to 12):");
	        if (numStrings >= 6 && numStrings <= 12) {
	            break;
	        } else {
	            System.out.println("Guitar must have between 6 and 12 strings. Try again.");
	        }
	    }

	    double price = 5000 + builder.getCost() + wood.getCost();
	    String serial = "V" + (int)(Math.random() * 9000 + 1000);

	    GuitarSpec spec = new GuitarSpec(builder, model, type, wood, numStrings);
	    inventory.addGuitar(serial, price, spec);

	    System.out.println("Guitar added with Serial No: " + serial + " and price ₹" + price);
	}

    public static void viewGuitars(List<Guitar> guitars) {
        if (guitars.isEmpty()) {
            System.out.println("No guitars found.");
            return;
        }
        for (Guitar g : guitars) {
            GuitarSpec s = g.getSpec();
            System.out.println("Serial: " + g.getSerialNumber() + ", Model: " + s.getModel() + ", Builder: " + s.getBuilder()
                    + ", Type: " + s.getType() + ", Wood: " + s.getWood() + ", Strings: " + s.getNumStrings() + ", Price: ₹" + g.getPrice());
        }
    }

    public static void searchGuitar(Scanner scanner, Inventory inventory) {
        Builder builder = promptYes(scanner, "Search by Builder?") ? selectEnum(scanner, Builder.values(), "Builder") : null;
        Type type = promptYes(scanner, "Search by Type?") ? selectEnum(scanner, Type.values(), "Type") : null;
        Wood wood = promptYes(scanner, "Search by Wood?") ? selectEnum(scanner, Wood.values(), "Wood") : null;
        String model = null;
        if (promptYes(scanner, "Search by Model?")) {
            System.out.print("Enter model name: ");
            model = scanner.nextLine().trim().toLowerCase();
        }

        int strings = promptYes(scanner, "Search by Number of Strings?") ? getIntInput(scanner, "Enter number of strings:") : 0;

        GuitarSpec filter = new GuitarSpec(builder,model, type, wood, strings);
        List<Guitar> results = inventory.search(filter);
        viewGuitars(results);
    }

    private static <T> T selectEnum(Scanner scanner, T[] values, String name) {
        while (true) {
            try {
                System.out.println("Choose " + name + ":");
                for (int i = 0; i < values.length; i++) {
                    System.out.println((i + 1) + ". " + values[i]);
                }
                int choice = scanner.nextInt();
                scanner.nextLine(); // clear newline
                return values[choice - 1];
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                scanner.nextLine();
            }
        }
    }

    private static boolean promptYes(Scanner scanner, String question) {
        System.out.print(question + " (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.startsWith("y");
    }

    private static int getIntInput(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message + " ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid number. Try again.");
                scanner.next();
            }
        }
    }
}
