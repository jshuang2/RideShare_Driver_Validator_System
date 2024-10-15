package rideshareSystem;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class Crash represents a vehicle crash.
 */
public class Crash {

    private LocalDate date;
    private CrashType type;
    private Name offendingDriverName;

    /**
     * Default constructor to allow Jackson to create a Crash object.
     */
    public Crash() {};

    /**
     * NonEmpty constructor for class Crash.
     * @param date date of the crash, as LocalDate.
     * @param type type of crash, as CrashType.
     * @param offendingDriverName name of the offending driver, as Name.
     */
    public Crash(LocalDate date, CrashType type, Name offendingDriverName) {
        this.date = date;
        this.type = type;
        this.offendingDriverName = offendingDriverName;
    }

    /**
     * Returns the date of the crash.
     * @return date of the crash, as LocalDate.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Returns the type of the crash.
     * @return type of the crash, as CrashType.
     */
    public CrashType getType() {
        return type;
    }

    /**
     * Returns the offending driver name.
     * @return name of the offending driver, as Name.
     */
    public Name getOffendingDriverName() {
        return offendingDriverName;
    }

    /**
     * Sets the date of the crash. Needed for Jackson.
     * @param date date of the crash, as LocalDate.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Sets the type of the crash. Needed for Jackson.
     * @param type type of the crash, as CrashType.
     */
    public void setType(CrashType type) {
        this.type = type;
    }

    /**
     * Sets the offending driver name. Needed for Jackson.
     * @param offendingDriverName offending driver's name, as Name.
     */
    public void setOffendingDriverName(Name offendingDriverName) {
        this.offendingDriverName = offendingDriverName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crash crash = (Crash) o;
        return Objects.equals(date, crash.date) && type == crash.type && Objects.equals(offendingDriverName, crash.offendingDriverName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, type, offendingDriverName);
    }

    @Override
    public String toString() {
        return "Crash{" +
                "date=" + date +
                ", type=" + type +
                ", offendingDriverName=" + offendingDriverName +
                '}';
    }
}
