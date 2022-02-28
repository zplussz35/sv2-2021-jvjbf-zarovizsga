package shipping;

import java.util.*;
import java.util.stream.Collectors;

public class ShippingService {
    private List<Transportable> packages = new ArrayList<>();

    public void addPackage(Transportable pack) {
        packages.add(pack);
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight) {
        return packages.stream()
                .filter(p -> p.isBreakable() == breakable)
                .filter(p -> p.getWeight() >= weight)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> collectTransportableByCountry() {
        Map<String, Integer> result = new HashMap<>();
        for (Transportable pack : packages) {
            if (!result.containsKey(pack.getDestinationCountry())) {
                result.put(pack.getDestinationCountry(), 1);
            } else {
                result.put(pack.getDestinationCountry(), result.get(pack.getDestinationCountry()) + 1);
            }
        }
        return result;
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        return packages.stream()
                .filter(p -> p.getClass() == InternationalPackage.class)
                .sorted(Comparator.comparingInt(p -> ((InternationalPackage) p).getDistance()))
                .collect(Collectors.toList());
    }

    public List<Transportable> getPackages() {
        return packages;
    }
}
