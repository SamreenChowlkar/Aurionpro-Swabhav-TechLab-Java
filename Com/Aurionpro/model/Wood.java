package Com.Aurionpro.model;

public enum Wood {
    MAHOGANY(3000), ALDER(2000), ADIRONDACK(3500), MAPLE(2500);

    private final int cost;

    Wood(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String toString() {
        return name();
    }
}
