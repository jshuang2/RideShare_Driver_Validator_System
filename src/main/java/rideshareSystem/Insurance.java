package rideshareSystem;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Class Insurance represents the insurance of a driver.
 */
public class Insurance {

    private Name vehicleOwner;
    private List<Name> driversCovered;
    private LocalDate expirationDate;

    /**
     * Default constructor to allow Jackson to create Insurance objects.
     */
    public Insurance() {};

    /**
     * NonEmpty constructor for class Insurance.
     * @param vehicleOwner vehicle owner stated on the insurance, as Name.
     * @param driversCovered drivers covered stated on the insurance, as a list of Name.
     * @param expirationDate expiration date of the insurance, as LocalDate.
     */
    public Insurance(Name vehicleOwner, List<Name> driversCovered, LocalDate expirationDate) {
        this.vehicleOwner = vehicleOwner;
        this.driversCovered = driversCovered;
        this.expirationDate = expirationDate;
    }

    /**
     * Returns the vehicle owner.
     * @return vehicle owner, as Name.
     */
    public Name getVehicleOwner() {
        return vehicleOwner;
    }

    /**
     * Returns the drivers covered by the insurance.
     * @return drivers covered, as a list of Name.
     */
    public List<Name> getDriversCovered() {
        return driversCovered;
    }

    /**
     * Returns the expiration date of the insurance.
     * @return expiration date, as LocalDate.
     */
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the vehicle owner. Needed for Jackson.
     * @param vehicleOwner vehicle owner to bet set, as Name.
     */
    public void setVehicleOwner(Name vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    /**
     * Sets the drivers covered. Needed for Jackson.
     * @param driversCovered drivers covered to be set, as a list of Name.
     */
    public void setDriversCovered(List<Name> driversCovered) {
        this.driversCovered = driversCovered;
    }

    /**
     * Sets the expiration date. Needed for Jackson.
     * @param expirationDate expiration date to be set, as LocalDate.
     */
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insurance insurance = (Insurance) o;
        return Objects.equals(vehicleOwner, insurance.vehicleOwner) && Objects.equals(driversCovered, insurance.driversCovered) && Objects.equals(expirationDate, insurance.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleOwner, driversCovered, expirationDate);
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "vehicleOwner=" + vehicleOwner +
                ", driversCovered=" + driversCovered +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
