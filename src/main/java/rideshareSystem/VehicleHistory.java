package rideshareSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class VehicleHistory represents a vehicle's history.
 */
public class VehicleHistory {

    private List<Violation> violations;
    private List<Crash> crashes;

    /**
     * Default constructor to allow Jackson to create VehicleHistory objects.
     */
    public VehicleHistory() {
        this.violations = new ArrayList<>();
        this.crashes = new ArrayList<>();
    }

    /**
     * NonEmpty constructor for VehicleHistory.
     * @param violations violations belonging to this vehicle, as List of Violation.
     * @param crashes crashes belonging to this vehicle, as List of Crash.
     */
    public VehicleHistory(List<Violation> violations, List<Crash> crashes) {
        this.violations = violations;
        this.crashes = crashes;
    }

    /**
     * Returns the list of violations belonging to the vehicle.
     * @return list of violations, as List of Violation.
     */
    public List<Violation> getViolations() {
        return violations;
    }

    /**
     * Returns the list of crashes belonging to the vehicle.
     * @return list of crashes, as List of Crash.
     */
    public List<Crash> getCrashes() {
        return crashes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleHistory that = (VehicleHistory) o;
        return Objects.equals(violations, that.violations) && Objects.equals(crashes, that.crashes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(violations, crashes);
    }

    @Override
    public String toString() {
        return "VehicleHistory{" +
                "violations=" + violations +
                ", crashes=" + crashes +
                '}';
    }
}
