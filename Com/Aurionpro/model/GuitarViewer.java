package Com.Aurionpro.model;
import java.util.List;

public class GuitarViewer {

    public static void viewAllGuitars(Inventory inventory) {
        System.out.println("---------------------------------------");
        System.out.println(" All Guitars in Inventory:");
        System.out.println("---------------------------------------");

        List<Guitar> guitars = inventory.getAllGuitars();
        if (guitars.isEmpty()) {
            System.out.println("No guitars found.");
            return;
        }

        for (Guitar guitar : guitars) {
            GuitarSpec spec = guitar.getSpec();
            System.out.println("Serial: " + guitar.getSerialNumber() +
                    ", Builder: " + spec.getBuilder() +
                    ", Type: " + spec.getType() +
                    ", Wood: " + spec.getWood() +
                    ", Price: ₹" + guitar.getPrice());
        }
        System.out.println();
    }
}

