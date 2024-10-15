package rideshareSystem;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class NonMovingViolation represents a non-moving violation.
 */
public class NonMovingViolation extends Violation {

    private NonMovingViolationType violationType;

    /**
     * Default constructor to allow Jackson to create NonMovingViolation objects.
     */
    public NonMovingViolation() {
    }

    /**
     * NonEmpty constructor for class NonMovingViolation.
     * @param date date of the violation, as LocalDate.
     * @param offendingDriverName offending driver's name, as Name.
     * @param violationType violation type, as NonMovingViolationType.
     */
    public NonMovingViolation(LocalDate date, Name offendingDriverName, NonMovingViolationType violationType) {
        super(date, offendingDriverName);
        this.violationType = violationType;
    }

    /**
     * Returns the violation type.
     * @return violation type, as NonMovingViolationType.
     */
    public NonMovingViolationType getViolationType() {
        return violationType;
    }

    /**
     * Sets the violation type. Needed for Jackson.
     * @param violationType violation type to be set, as NonMovingViolationType.
     */
    public void setViolationType(NonMovingViolationType violationType) {
        this.violationType = violationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NonMovingViolation that = (NonMovingViolation) o;
        return violationType == that.violationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), violationType);
    }

    @Override
    public String toString() {
        return "NonMovingViolation{" +
                "violationType=" + violationType +
                ", date=" + date +
                ", offendingDriverName=" + offendingDriverName +
                '}';
    }
}
