package rideshareSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Class BirthDate represents a date of birth.
 */
public class Birthdate {

    private LocalDate birthDate;

    /**
     * Default constructor to allow Jackson to create a BirthDate object.
     */
    public Birthdate() {};

    /**
     * NonEmpty Constructor for class BirthDate
     * @param birthDate birthdate, as String.
     */
    public Birthdate(String birthDate) {  // 'yyyy-MM-dd' format
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * Returns the birthDate
     * @return birthDate, as LocalDate.
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Setter for BirthDate. Used for Jackson.
     * @param birthDate birthDate, as LocalDate.
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Birthdate birthdate = (Birthdate) o;
        return Objects.equals(birthDate, birthdate.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(birthDate);
    }

    @Override
    public String toString() {
        return "Birthdate{" +
                "birthDate=" + birthDate +
                '}';
    }
}
