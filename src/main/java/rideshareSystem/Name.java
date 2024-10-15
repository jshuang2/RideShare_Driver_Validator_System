package rideshareSystem;

import java.util.Objects;

/**
 * Class Name represents a name.
 */
public class Name {

    private String firstName;
    private String lastName;

    /**
     * Default constructor to allow Jackson to create Name objects.
     */
    public Name () {};

    /**
     * NonEmpty constructor for class Name.
     * @param firstName first name, as String.
     * @param lastName last name, as String.
     */
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the first name.
     * @return first name, as String.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name.
     * @return last name, as String.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the first name of the name. Needed for Jackson.
     * @param firstName first name to be set, as String.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of the name. Needed for Jackson.
     * @param lastName last name to be set, as String.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstName, name.firstName) && Objects.equals(lastName, name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
