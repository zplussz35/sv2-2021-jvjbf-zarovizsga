package shipping;

public class NationalPackage implements Transportable {
    private int weight;
    private boolean breakable;

    public NationalPackage(int weight, boolean breakable) {
        this.weight = weight;
        this.breakable = breakable;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public int calculateShippingPrice() {
        int fee = 1000;

        if (isBreakable()) {
            return 2 * fee;
        }
        return fee;
    }
}
