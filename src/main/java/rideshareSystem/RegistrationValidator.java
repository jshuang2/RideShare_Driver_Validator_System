package rideshareSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Class RegistrationValidator provides functionality to
 * validate various aspects of a driver in order for them to be registered.
 */
public class RegistrationValidator {

    private static final Integer MIN_AGE = 21;
    private static final String ACCEPTED_COUNTRY_1 = "USA";
    private static final String ACCEPTED_COUNTRY_2 = "Canada";
    private static final Integer MIN_LICENSE_AGE_IN_MONTHS = 6;
    private static final Integer MAX_VEHICLE_AGE_IN_YEARS = 15;
    private static final Long MIN_MOVING_VIOLATION_AGE_IN_MONTHS = 6L;
    private static final Long MIN_CRASH_AGE_IN_MONTHS = 6L;
    private static final HashSet<MovingViolationType> UNACCEPTABLE_MOVING_VIOLATIONS = new HashSet<>();
    static {
        UNACCEPTABLE_MOVING_VIOLATIONS.add(MovingViolationType.RECKLESS_DRIVING);
        UNACCEPTABLE_MOVING_VIOLATIONS.add(MovingViolationType.SPEEDING);
        UNACCEPTABLE_MOVING_VIOLATIONS.add(MovingViolationType.DUI);
        UNACCEPTABLE_MOVING_VIOLATIONS.add(MovingViolationType.DRIVING_WITHOUT_VALID_LICENSE);
    }

    /**
     * Validates the registration of a driver by calling various helper validation methods.
     * @param driver driver to be validated, as Driver.
     * @return returns true if the driver passes as validations. False if not.
     */
    public static boolean validateDriver(Driver driver) {

        Birthdate birthdate = driver.getBirthdate();
        Insurance insurance = driver.getInsurance();

        if (!validateAge(birthdate.getBirthDate())) return false;
        if (!validateDriversLicense(driver)) return false;
        if (!validateVehicleAge(driver.getVehicles())) return false;
        if (!validateInsurance(driver.getName(), insurance.getDriversCovered(), insurance.getExpirationDate())) return false;
        if (!validateDriverHistory(driver.getDriverHistory().getViolations())) return false;
        if (!validateVehicleHistory(driver.getVehicles())) return false;

        return true;
    }

    /**
     * Validates that the driver meets the minimum age requirement.
     * @param birthDate birthdate to be validated, as LocalDate.
     * @return true if passed, false if failed.
     */
    private static boolean validateAge(LocalDate birthDate) {
        return LocalDate.now().minusYears(MIN_AGE).isAfter(birthDate);
    }

    /**
     *
     * @param driver validates the driver's driver's license by calling various helper validation methods.
     * @return true if passed, false if failed.
     */
    private static boolean validateDriversLicense(Driver driver) {

        DriversLicense license = driver.getDriversLicense();
        LocalDate birthDate = driver.getBirthdate().getBirthDate();

        if (!validateName(driver.getName(), license.getName())) return false;
        if (!validateBirthDate(birthDate, license.getBirthdate())) return false;
        if (!validateCountryOfIssuance(license.getCountry())) return false;
        if (!validateDateOfIssuance(license.getIssuanceDate())) return false;
        if (!validateExpirationDate(license.getExpirationDate())) return false;

        return true;
    }

    /**
     * Validates that the driver's name on the application matches the name on the driver's license.
     * @param nameOnApp name on the application, as Name.
     * @param nameOnLicense name on the license, as Name.
     * @return true if passed, false if failed.
     */
    private static boolean validateName(Name nameOnApp, Name nameOnLicense) {
        return nameOnApp.equals(nameOnLicense);
    }

    /**
     * Validates that the driver's birthdate on the application matches the name on the license.
     * @param birthDateOnApp birthdate on the application, as LocalDate.
     * @param birthDateOnLicense birthdate on the license, as LocalDate.
     * @return true if passed, false if failed.
     */
    private static boolean validateBirthDate(LocalDate birthDateOnApp, LocalDate birthDateOnLicense) {
        return birthDateOnApp.isEqual(birthDateOnLicense);
    }

    /**
     * Validates that the driver's license was issued in an accepted country.
     * @param country the country of issuance, as String.
     * @return true if passed, failse if failed.
     */
    private static boolean validateCountryOfIssuance(String country) {
        return country.equalsIgnoreCase(ACCEPTED_COUNTRY_1) || country.equalsIgnoreCase(ACCEPTED_COUNTRY_2);
    }

    /**
     * Validates that the driver's license was issued at least six months ago.
     * @param dateOfIssuance the date the license was issued, as LocalDate.
     * @return true if passed, false if failed.
     */
    private static boolean validateDateOfIssuance(LocalDate dateOfIssuance) {
        return dateOfIssuance.plusMonths(MIN_LICENSE_AGE_IN_MONTHS).isBefore(LocalDate.now());
    }

    /**
     * Validates that the driver's license is still valid.
     * @param expirationDate the expiration date of the driver's license, as LocalDate.
     * @return true if passed, false if failed.
     */
    private static boolean validateExpirationDate(LocalDate expirationDate) {
        return expirationDate.isAfter(LocalDate.now());
    }

    /**
     * Validates that all vehicles associated with the driver are within the acceptable age limit.
     * @param vehicles the set of vehicles associated with the driver, as HashSet of Vehicle.
     * @return true if passed, false if failed.
     */
    private static boolean validateVehicleAge(HashSet<Vehicle> vehicles) {
        if (vehicles.isEmpty()) return false;

        return vehicles.stream().allMatch(vehicle -> vehicle.getYear() + MAX_VEHICLE_AGE_IN_YEARS >= LocalDate.now().getYear());
    }

    /**
     * Validates that the driver's insurance covers the driver and is still valid.
     * @param driverName the driver's name, as Name.
     * @param driversCovered the list of names covered by the insurance, as List of Name.
     * @param expirationDate the expiration date of the insurance, as LocalDate.
     * @return true if passed, false if failed.
     */
    private static boolean validateInsurance(Name driverName, List<Name> driversCovered, LocalDate expirationDate) {
        if (driversCovered.isEmpty()) return false;
        if (driversCovered.stream().noneMatch(name -> name.equals(driverName))) return false;
        return !expirationDate.isBefore(LocalDate.now());
    }

    /**
     * Validates the driver's history by checking for any unacceptable moving violations.
     * @param violations the list of violations in the driver's history, as List of Violation.
     * @return true if passed, false if failed.
     */
    private static boolean validateDriverHistory(List<Violation> violations) {

        if (violations.isEmpty()) return true;

        List<MovingViolation> movingViolations = getMovingViolations(violations);

        return movingViolations.stream().noneMatch(movingViolation -> UNACCEPTABLE_MOVING_VIOLATIONS.contains(movingViolation.getViolationType()));
    }

    /**
     * Validates the history of all vehicles associated with the driver by checking for recent crashes
     * and recent moving violations.
     * @param vehicles the set of vehicles associated with the driver, as HashSet of Vehicle.
     * @return true if passed, false if failed.
     */
    private static boolean validateVehicleHistory(HashSet<Vehicle> vehicles) {

        if (vehicles.isEmpty()) return false;

        for (Vehicle vehicle : vehicles) {

            List<Crash> crashes = vehicle.getHistory().getCrashes();
            List<MovingViolation> movingViolations = getMovingViolations(vehicle.getHistory().getViolations());

            if (!validateCrashes(crashes)) return false;
            if (!validateMovingViolations(movingViolations)) return false;
        }

        return true;
    }

    /**
     * Validates that all crashes associated with a vehicle occurred more than the minimum specified months ago.
     * @param crashes the list of crashes associated with a vehicle, as List of Crash.
     * @return true if passed, false if failed.
     */
    private static boolean validateCrashes(List<Crash> crashes) {
        if (crashes.isEmpty()) return true;

        return crashes.stream().allMatch(crash -> crash.getDate()
                .plusMonths(MIN_CRASH_AGE_IN_MONTHS)
                .isBefore(LocalDate.now()));
    }

    /**
     * Validates that all moving violations associated with a vehicle occurred more than the minimum specified months ago.
     * @param movingViolations the list of moving violations associated with a vehicle, as List of MovingViolation.
     * @return true if passed, false if failed.
     */
    private static boolean validateMovingViolations(List<MovingViolation> movingViolations) {
        if (movingViolations.isEmpty()) return true;

        return movingViolations.stream().allMatch(movingViolation -> movingViolation.getDate()
                .plusMonths(MIN_MOVING_VIOLATION_AGE_IN_MONTHS)
                .isBefore(LocalDate.now()));
    }

    /**
     * Returns a list of MovingViolation objects from the driver's list of violations.
     * @param violations the list of violations to be checked, as List of Violation.
     * @return the list of moving violations.
     */
    private static List<MovingViolation> getMovingViolations(List<Violation> violations) {

        List<MovingViolation> movingViolations = new ArrayList<>();

        for (Violation violation: violations) {
            if (violation.getClass().equals(MovingViolation.class)) {
                movingViolations.add((MovingViolation) violation);
            }
        }

        return movingViolations;
    }

}
