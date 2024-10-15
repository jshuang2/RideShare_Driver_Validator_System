package rideshareSystem;

import java.util.List;

/**
 * Class DriverSearch executes the functionality of searching for drivers.
 */
public class DriverSearch {

    /**
     * Searches for the driver(s) that match the given last name.
     * @param lastName last name to be searched, as String.
     * @param drivers list of drivers. This can be either prospective drivers or registered drivers.
     */
    public static void provideDriverInfo(String lastName, List<Driver> drivers) {

        boolean printed = false;

        for (Driver driver : drivers) {
            if (driver.getName().getLastName().equalsIgnoreCase(lastName)) {
                printDriverInfo(driver);
                printed = true;
            }
        }

        if (!printed) System.out.println("No registered driver found");
    }

    /**
     * Prints the driver info of the input driver.
     * @param driver driver to be printed, as Driver.
     */
    private static void printDriverInfo(Driver driver) {
        System.out.println(driver.toString());
    }

}
