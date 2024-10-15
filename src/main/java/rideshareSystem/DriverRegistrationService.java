package rideshareSystem;

import java.util.List;

/**
 * Class DriverRegistrationService represents the service the registers prospective drivers.
 */
public class DriverRegistrationService {

    private static Integer registeredDriversCounter = 0;

    /**
     * Registers prospective drivers if they qualify.
     * @param registeredDrivers the current list of registered drivers, as a list of Driver.
     * @param prospectiveDrivers the current list of prospective drivers, as a list of Driver.
     */
    public static void registerDrivers(List<Driver> registeredDrivers, List<Driver> prospectiveDrivers) {

        Integer currentDriverCount = registeredDriversCounter;
        Integer prospectiveDriversCount = prospectiveDrivers.size();

        // Iterate through the list of prospective drivers and validate each of them.
        // Add them to the registered drivers list if the validation passes.
        for (Driver prospectiveDriver : prospectiveDrivers) {
            if (RegistrationValidator.validateDriver(prospectiveDriver)) {
                registeredDrivers.add(prospectiveDriver);
                registeredDriversCounter++;
            }
        }

        System.out.println("\n" + (registeredDriversCounter - currentDriverCount) +
                " drivers were successfully registered from a list of " + prospectiveDriversCount + " prospective drivers.");

    }

    /**
     * Prints all registered drivers.
     * @param registeredDrivers registered drivers to print, as List of Driver.
     */
    public static void printAllRegisteredDrivers(List<Driver> registeredDrivers) {

        if (registeredDrivers.isEmpty()) System.out.println("There are no registered drivers.");

        registeredDrivers.forEach(System.out::println);
    }

}
