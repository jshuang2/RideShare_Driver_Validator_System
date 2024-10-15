package rideshareSystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Class Driver represents a driver.
 */
public class Driver implements Comparable<Driver>{

    private Name name;
    private Birthdate birthdate;
    private DriversLicense driversLicense;
    private HashSet<Vehicle> vehicles;
    private Insurance insurance;
    private DriverHistory driverHistory;

    /**
     * Default constructor to allow Jackson to create Driver objects.
     */
    public Driver() {};

    /**
     * NonEmpty constructor for class Driver.
     * @param name name of the driver, as Name.
     * @param birthdate birthdate of the driver, as Birthdate.
     * @param driversLicense driver's license of the driver, as DriversLicense.
     * @param vehicles vehicles that the driver is able to drive, as a HashSet of Vehicle.
     * @param insurance the driver's insurance, as Insurance.
     * @param driverHistory the driver's driver history, as DriverHistory.
     */
    public Driver(Name name, Birthdate birthdate, DriversLicense driversLicense, HashSet<Vehicle> vehicles, Insurance insurance, DriverHistory driverHistory) {
        this.name = name;
        this.birthdate = birthdate;
        this.driversLicense = driversLicense;
        this.vehicles = vehicles;
        this.insurance = insurance;
        this.driverHistory = driverHistory;
    }

    /**
     * Returns the name of the driver.
     * @return name of the driver, as Name.
     */
    public Name getName() {
        return name;
    }

    /**
     * Returns the birthdate of the driver.
     * @return birthdate, as Birthdate.
     */
    public Birthdate getBirthdate() {
        return birthdate;
    }

    /**
     * Returns the driver's license of the driver.
     * @return drivers license, as DriversLicense.
     */
    public DriversLicense getDriversLicense() {
        return driversLicense;
    }

    /**
     * Returns the vehicles that the driver is allowed to drive.
     * @return vehicles, as a HashSet of Vehicle.
     */
    public HashSet<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Returns the insurance of the driver.
     * @return insurance of the driver, as Insurance.
     */
    public Insurance getInsurance() {
        return insurance;
    }

    /**
     * Returns the driver's driver history.
     * @return driver's driver history, as DriverHistory.
     */
    public DriverHistory getDriverHistory() {
        return driverHistory;
    }

    /**
     * Sets the name of the driver. Needed for Jackson.
     * @param name name of the driver, as Name.
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * Sets the birthdate of the driver. Needed for Jackson.
     * @param birthdate birthdate of the driver, as Birthdate.
     */
    public void setBirthdate(Birthdate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Sets the driver's license of the driver. Needed for Jackson.
     * @param driversLicense driver's license, as DriversLicense.
     */
    public void setDriversLicense(DriversLicense driversLicense) {
        this.driversLicense = driversLicense;
    }

    /**
     * Sets the vehicles of the driver. Needed for Jackson.
     * @param vehicles vehicles of the driver, as a hashset of Vehicle.
     */
    public void setVehicles(HashSet<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * Sets the insurance of the driver. Needed for Jackson.
     * @param insurance insurance of the driver, as Insurance.
     */
    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    /**
     * Sets the driver's driver history. Needed for Jackson.
     * @param driverHistory driver history, as DriverHistory.
     */
    public void setDriverHistory(DriverHistory driverHistory) {
        this.driverHistory = driverHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(name, driver.name) && Objects.equals(birthdate, driver.birthdate) && Objects.equals(driversLicense, driver.driversLicense) && Objects.equals(vehicles, driver.vehicles) && Objects.equals(insurance, driver.insurance) && Objects.equals(driverHistory, driver.driverHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthdate, driversLicense, vehicles, insurance, driverHistory);
    }

    /**
     * Overrides Driver's toString() method. This method utilizes streams to call each vehicle/violation
     * toString() method and then concatenates it together in a formatted way.
     * @return
     */
    @Override
    public String toString() {

        List<MovingViolation> movingViolations = new ArrayList<>();

        // Finds all the moving violations and adds them to the list, movingViolations.
        for (Violation violation: this.driverHistory.getViolations()) {
            if (violation.getClass().equals(MovingViolation.class)) {
                movingViolations.add((MovingViolation) violation);
            }
        }

        // Convert vehicles to string using a stream and join them
        String vehiclesString = this.getVehicles().stream()
                .map(Vehicle::toString)
                .collect(Collectors.joining("\n\t"));

        // Convert moving violations to string using a stream and join them
        String violationsString = movingViolations.stream()
                .map(violation -> "\t\t\t" + violation.getViolationType().toString())
                .collect(Collectors.joining("\n\n"));

        // Build the final string
        return this.getName().getLastName() + ", " + this.getName().getFirstName() + "\n\n\t" +
                vehiclesString +
                (movingViolations.isEmpty() ? "" : "\tDriving violations: \n\n" + violationsString + "\n");

    }

    /**
     * compareTo override is needed to effectively compare Driver objects against each other and sort them in a list.
     * @param other the object to be compared.
     * @return either a negative integer, 0, or positive integer depending on the comparison result.
     */
    @Override
    public int compareTo(Driver other) {
        // Compare last names first.
        int lastNameComparison = this.getName().getLastName().compareToIgnoreCase(other.getName().getLastName());

        // If the last names are not the same, then we're done.
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        // Else if they are the same, compare the first names.
        return this.getName().getFirstName().compareToIgnoreCase(other.getName().getFirstName());
    }
}
