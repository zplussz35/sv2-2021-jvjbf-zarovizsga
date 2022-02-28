package shipping;

public class InternationalPackage implements Transportable {
    private int weight;
    private boolean breakable;
    private String destinationCountry;
    private int distance;

    public InternationalPackage(int weight, boolean breakable, String destinationCountry, int distance) {
        this.weight = weight;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
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
    public String getDestinationCountry() {
        return destinationCountry;
    }

    @Override
    public int calculateShippingPrice() {
        int fee = 1200;
        int kmFee = 10;

        if (isBreakable()) {
            return 2 * fee + kmFee * distance;
        }
        return fee + kmFee * distance;
    }

    public int getDistance() {
        return distance;
    }
}
