package rideshareSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class DriverHistory represents a driver's driver history.
 */
public class DriverHistory {

    private List<Violation> violations;
    private List<Crash> crashes;

    /**
     * Default constructor to allow Jackson to create DriverHistory objects.
     */
    public DriverHistory() {
        this.violations = new ArrayList<>();
        this.crashes = new ArrayList<>();
    }

    /**
     * NonEmpty constructor for class DriverHistory.
     * @param violations driver's violations, as a list of Violation.
     * @param crashes driver's crashes, as a list of Crash.
     */
    public DriverHistory(List<Violation> violations, List<Crash> crashes) {
        this.violations = violations;
        this.crashes = crashes;
    }

    /**
     * Returns the list of violations.
     * @return list of violations.
     */
    public List<Violation> getViolations() {
        return violations;
    }

    /**
     * Returns the list of crashes.
     * @return list of crashes.
     */
    public List<Crash> getCrashes() {
        return crashes;
    }

    /**
     * Sets the list of violations. Needed for Jackson.
     * @param violations violations to be set, as a List of Violation.
     */
    public void setViolations(List<Violation> violations) {
        this.violations = violations;
    }

    /**
     * Sets the list of crashes. Needed for Jackson.
     * @param crashes crashes to be set, as a List of Crash.
     */
    public void setCrashes(List<Crash> crashes) {
        this.crashes = crashes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverHistory that = (DriverHistory) o;
        return Objects.equals(violations, that.violations) && Objects.equals(crashes, that.crashes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(violations, crashes);
    }

    @Override
    public String toString() {
        return "DriverHistory{" +
                "violations=" + violations +
                ", crashes=" + crashes +
                '}';
    }
}
