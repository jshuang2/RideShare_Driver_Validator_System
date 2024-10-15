package rideshareSystem;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class Violation represents a violation.
 * Jackson annotation to allow Jackson to know where to find the Violation subclasses.
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MovingViolation.class, name = "MOVING_VIOLATION"),
        @JsonSubTypes.Type(value = NonMovingViolation.class, name = "NON_MOVING_VIOLATION")
})
public abstract class Violation {

    protected LocalDate date;
    protected Name offendingDriverName;

    /**
     * Default constructor to allow Jackson to create Violation objects.
     */
    public Violation() {};

    /**
     * NonEmpty constructor for class Violation.
     * @param date date of the violation, as LocalDate.
     * @param offendingDriverName offending driver's name, as Name.
     */
    public Violation(LocalDate date, Name offendingDriverName) {
        this.date = date;
        this.offendingDriverName = offendingDriverName;
    }

    /**
     * Returns the date of the violation.
     * @return date, as LocalDate.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * returns the offending driver's name.
     * @return name of the offending driver, as Name.
     */
    public Name getOffendingDriverName() {
        return offendingDriverName;
    }

    /**
     * Sets the date of the violation. Used for Jackson.
     * @param date date of the violation, as LocalDate.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Sets the offending driver's name for the violation. Used for Jackson.
     * @param offendingDriverName offending driver's name, as Name.
     */
    public void setOffendingDriverName(Name offendingDriverName) {
        this.offendingDriverName = offendingDriverName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Violation violation = (Violation) o;
        return Objects.equals(date, violation.date) && Objects.equals(offendingDriverName, violation.offendingDriverName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, offendingDriverName);
    }
}
