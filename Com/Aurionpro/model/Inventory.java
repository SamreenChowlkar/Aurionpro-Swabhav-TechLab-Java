package Com.Aurionpro.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List<Guitar> guitars = new ArrayList<>();

    public void addGuitar(String serialNumber, double price, GuitarSpec spec) {
        guitars.add(new Guitar(serialNumber, price, spec));
    }

    public List<Guitar> search(GuitarSpec searchSpec) {
        List<Guitar> matching = new ArrayList<>();
        for (Guitar guitar : guitars) {
            if (guitar.getSpec().matches(searchSpec)) {
                matching.add(guitar);
            }
        }
        return matching;
    }

    public List<Guitar> getAllGuitars() {
        return new ArrayList<>(guitars);
    }

    public boolean deleteGuitar(String serialNumber) {
        return guitars.removeIf(g -> g.getSerialNumber().equalsIgnoreCase(serialNumber));
    }
}