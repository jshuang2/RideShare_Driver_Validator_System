package rideshareSystem;

import java.util.Objects;

/**
 * Class Vehicle represents a vehicle.
 */
public class Vehicle {

    private String make;
    private String model;
    private String color;
    private Integer year;
    private String plateNumber;
    private Name owner;
    private VehicleHistory history;

    /**
     * Default constructor to allow Jackson to create Vehicle objects.
     */
    public Vehicle() {};

    /**
     * NonEmpty constructor for class Vehicle.
     * @param make make of the vehicle, as String.
     * @param model model of the vehicle, as String.
     * @param color color of the vehicle, as String.
     * @param year year of the vehicle, as Integer.
     * @param plateNumber plate number of the vehicle, as String.
     * @param owner owner of the vehicle, as Name.
     * @param history vehicle history of the vehicle, as VehicleHistory.
     */
    public Vehicle(String make, String model, String color, Integer year, String plateNumber, Name owner, VehicleHistory history) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.plateNumber = plateNumber;
        this.owner = owner;
        this.history = history;
    }

    /**
     * Returns the make of the vehicle.
     * @return make, as String.
     */
    public String getMake() {
        return make;
    }

    /**
     * Returns the model of the vehicle.
     * @return model, as String.
     */
    public String getModel() {
        return model;
    }

    /**
     * Returns the color of the vehicle.
     * @return color, as String.
     */
    public String getColor() {
        return color;
    }

    /**
     * Returns the year of the vehicle.
     * @return year, as Integer.
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Returns the plate number of the vehicle.
     * @return plate number, as String.
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * Returns the owner of the vehicle.
     * @return owner, as Name.
     */
    public Name getOwner() {
        return owner;
    }

    /**
     * Returns the vehicle history of the vehicle.
     * @return vehicle history, as VehicleHistory.
     */
    public VehicleHistory getHistory() {
        return history;
    }

    /**
     * Sets the make of the vehicle. Needed for Jackson.
     * @param make make of the vehicle, as String.
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Sets the model of the vehicle. Needed for Jackson.
     * @param model model of the vehicle, as String.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Sets the color of the vehicle. Needed for Jackson.
     * @param color color of the vehicle, as String.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Sets the year of the vehicle. Needed for Jackson.
     * @param year year of the vehicle, as Integer.
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Sets the plate number of the vehicle. Needed for Jackson.
     * @param plateNumber plate number of the vehicle, as String.
     */
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    /**
     * Sets the owner of the vehicle. Needed for Jackson.
     * @param owner owner of the vehicle, as Name.
     */
    public void setOwner(Name owner) {
        this.owner = owner;
    }

    /**
     * Sets the vehicle history of the vehicle. Needed for Jackson.
     * @param history vehicle history of the vehicle, as VehicleHistory.
     */
    public void setHistory(VehicleHistory history) {
        this.history = history;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(make, vehicle.make) && Objects.equals(model, vehicle.model) && Objects.equals(year, vehicle.year) && Objects.equals(plateNumber, vehicle.plateNumber) && Objects.equals(owner, vehicle.owner) && Objects.equals(history, vehicle.history);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, year, plateNumber, owner, history);
    }

    @Override
    public String toString() {
        return this.getYear() + " "
                + this.getColor() + " "
                + this.getMake() + " "
                + this.getModel() + ", "
                + this.getPlateNumber() + "\n\n\t";
    }
}
