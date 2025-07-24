package Com.Aurionpro.model;

public class GuitarSpec {
    private Builder builder;
    private Type type;
    private Wood wood;
    private String model;
    private int numStrings;

    public GuitarSpec(Builder builder, String model, Type type, Wood wood, int numStrings) {
        this.builder = builder;
        this.model = (model == null) ? null : model.toLowerCase();
        this.type = type;
        this.wood = wood;
        this.numStrings = numStrings;
    }

    public Builder getBuilder() { return builder; }
    public Type getType() { return type; }
    public Wood getWood() { return wood; }
    public String getModel() { return model; }
    public int getNumStrings() { return numStrings; }

    public boolean matches(GuitarSpec other) {
        if (other.builder != null && builder != other.builder) return false;
        if (other.type != null && type != other.type) return false;
        if (other.wood != null && wood != other.wood) return false;
        if (other.model != null && !model.equalsIgnoreCase(other.model)) return false;
        if (other.numStrings != 0 && numStrings != other.numStrings) return false;
        return true;
    }
}