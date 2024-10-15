package rideshareSystem;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class MovingViolation represents a moving violation.
 */
public class MovingViolation extends Violation {

    private MovingViolationType violationType;

    /**
     * Default constructor to allow Jackson to create MovingViolation objects.
     */
    public MovingViolation () {};

    /**
     * NonEmpty constructor for class MovingViolation.
     * @param date date of the violation, as LocalDate.
     * @param offendingDriverName offending driver's name, as Name.
     * @param violationType violation type, as a MovingViolationType.
     */
    public MovingViolation(LocalDate date, Name offendingDriverName, MovingViolationType violationType) {
        super(date, offendingDriverName);
        this.violationType = violationType;
    }

    /**
     * Returns the violation type.
     * @return violation type, as MovingViolationType.
     */
    public MovingViolationType getViolationType() {
        return violationType;
    }

    /**
     * Sets the violation type. Needed for Jackson.
     * @param violationType violation type to be set, as MovingViolationType.
     */
    public void setViolationType(MovingViolationType violationType) {
        this.violationType = violationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MovingViolation that = (MovingViolation) o;
        return violationType == that.violationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), violationType);
    }

    @Override
    public String toString() {
        return "\t\t" + this.violationType.toString() + "\n\n";
    }
}
