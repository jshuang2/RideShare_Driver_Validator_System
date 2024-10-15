package rideshareSystem;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class DriversLicense represents a driver's license.
 */
public class DriversLicense {

    private String uniqueNumber;
    private Name name;
    private String address;
    private LocalDate birthdate;
    private String state;
    private String country;
    private LocalDate issuanceDate;
    private LocalDate expirationDate;

    /**
     * Default constructor to allow Jackson to create DriversLicense objects.
     */
    public DriversLicense() {};

    /**
     * NonEmpty constructor for class DriversLicense.
     * @param uniqueNumber unique number of the driver's license, as String.
     * @param name name of the driver on the license, as Name.
     * @param address address of the driver on the license, as String.
     * @param birthdate birthdate of the driver on the license, as LocalDate.
     * @param state state of issuance on the license, as String.
     * @param country country of issuance on the license, as String.
     * @param issuanceDate issuance date of the license, as LocalDate.
     * @param expirationDate expiration date of the license, as LocalDate.
     */
    public DriversLicense(String uniqueNumber, Name name, String address, LocalDate birthdate, String state, String country, LocalDate issuanceDate, LocalDate expirationDate) {
        this.uniqueNumber = uniqueNumber;
        this.name = name;
        this.address = address;
        this.birthdate = birthdate;
        this.state = state;
        this.country = country;
        this.issuanceDate = issuanceDate;
        this.expirationDate = expirationDate;
    }

    /**
     * Returns the unique number of the license.
     * @return license's unique number, as String.
     */
    public String getUniqueNumber() {
        return uniqueNumber;
    }

    /**
     * Returns the name of the driver on the license.
     * @return name, as Name.
     */
    public Name getName() {
        return name;
    }

    /**
     * Returns the address of the driver on the license.
     * @return address, as String.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the birthdate of the driver on the license.
     * @return birthdate, as LocalDate.
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * Returns the state of issuance on the license.
     * @return state of issuance, as String.
     */
    public String getState() {
        return state;
    }

    /**
     * Returns the country of issuance on the license.
     * @return country of issuance, as String.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Returns the issuance date of the license.
     * @return issuance date, as LocalDate.
     */
    public LocalDate getIssuanceDate() {
        return issuanceDate;
    }

    /**
     * Returns the expiration date of the license.
     * @return expiration date, as LocalDate.
     */
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the unique number of the license. Needed for Jackson.
     * @param uniqueNumber uniqueNumber to be set, as String.
     */
    public void setUniqueNumber(String uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    /**
     * Sets the name of the driver on the license. Needed for Jackson.
     * @param name name to be set, as Name.
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * Sets the address of the driver on the license. Needed for Jackson.
     * @param address address to be set, as String.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the birthdate of the driver on the license. Needed for Jackson.
     * @param birthdate birthdate to be set, as LocalDate.
     */
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Sets the state of issuance on the license. Needed for Jackson.
     * @param state state of issuance to be set, as String.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Sets the country of issuance on the license. Needed for Jackson.
     * @param country country of issuance to be set, as String.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Sets the issuance date of the license. Needed for Jackson.
     * @param issuanceDate issuance date to be set, as LocalDate.
     */
    public void setIssuanceDate(LocalDate issuanceDate) {
        this.issuanceDate = issuanceDate;
    }

    /**
     * Sets the expiration date of the license. Needed for Jackson.
     * @param expirationDate expiration date to be set, as LocalDate.
     */
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriversLicense that = (DriversLicense) o;
        return Objects.equals(uniqueNumber, that.uniqueNumber) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(birthdate, that.birthdate) && Objects.equals(state, that.state) && Objects.equals(country, that.country) && Objects.equals(issuanceDate, that.issuanceDate) && Objects.equals(expirationDate, that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueNumber, name, address, birthdate, state, country, issuanceDate, expirationDate);
    }

    @Override
    public String toString() {
        return "DriversLicense{" +
                "uniqueNumber='" + uniqueNumber + '\'' +
                ", name=" + name +
                ", address='" + address + '\'' +
                ", birthdate=" + birthdate +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", issuanceDate=" + issuanceDate +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
