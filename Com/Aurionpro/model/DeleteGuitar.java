package Com.Aurionpro.model;

import java.util.Scanner;

public class DeleteGuitar {
	public static void deleteGuitar(Inventory inventory, Scanner scanner) {
	    String serial;
	    do {
	        System.out.print("Enter Serial Number of the guitar to delete: ");
	        serial = scanner.nextLine().trim();
	        if (serial.isEmpty()) {
	            System.out.println("Serial number cannot be empty. Try again.");
	        }
	    } while (serial.isEmpty());

	    boolean deleted = inventory.deleteGuitar(serial);
	    if (deleted) {
	        System.out.println("Guitar with serial number '" + serial + "' has been deleted.");
	    } else {
	        System.out.println("No guitar found with serial number: " + serial);
	    }
	}

}
