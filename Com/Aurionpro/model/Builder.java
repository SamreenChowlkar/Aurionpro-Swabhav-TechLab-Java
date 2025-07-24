package Com.Aurionpro.model;

public enum Builder {
    FENDER(2000), MARTIN(3000), GIBSON(2500), COLLINGS(1800);

    private final int cost;

    Builder(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String toString() {
        return name();
    }
}
