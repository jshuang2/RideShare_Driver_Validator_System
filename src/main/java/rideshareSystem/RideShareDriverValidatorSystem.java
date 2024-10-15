package rideshareSystem;

import java.util.*;

/**
 * Class RideShareDriverValidatorSystem represents the controller for executing the over-arching
 * program functionality.
 */
public class RideShareDriverValidatorSystem {

    private List<Driver> prospectiveDrivers;
    private List<Driver> registeredDrivers;
    private static final String dataFileName = "prospective_drivers.json";
    private static final String jsonMapKey = "prospective_drivers";

    /**
     * Constructor for class RideShareDriverValidatorSystem.
     * Upon creation, calls the method to add prospective drivers to the list ot prospective drivers.
     * Passes in the file name of the JSON file.
     */
    public RideShareDriverValidatorSystem() {
        prospectiveDrivers = new ArrayList<>();
        registeredDrivers = new ArrayList<>();

        this.prospectiveDrivers = ProspectiveDriverService.addProspectiveDrivers(dataFileName, jsonMapKey);
        Collections.sort(this.prospectiveDrivers);
    }

    /**
     * Executes the I/O functionality between the system and the user.
     */
    public void runSystem() {

        boolean flag = true;

        Scanner scanner = new Scanner(System.in);

        while (flag) {

            System.out.println("\nWhat would you like to do? Enter the #: ");
            this.showOptions();
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "1" -> this.runSearchDriver(true);
                case "2" -> this.runSearchDriver(false);
                case "3" -> DriverRegistrationService.printAllRegisteredDrivers(this.registeredDrivers);
                case "4" -> ProspectiveDriverService.printAllProspectiveDrivers(this.prospectiveDrivers);
                case "5" -> {
                    DriverRegistrationService.registerDrivers(this.registeredDrivers, this.prospectiveDrivers);
                    ProspectiveDriverService.removeProspectiveDrivers(this.prospectiveDrivers);
                }
                case "6" -> flag = false;
            }
        }

    }

    /**
     * Prints the valid options the user can do.
     */
    private void showOptions() {
        System.out.println("(1): search registered driver");
        System.out.println("(2): search prospective driver");
        System.out.println("(3): show all registered drivers");
        System.out.println("(4): show all prospective drivers");
        System.out.println("(5): register prospective drivers");
        System.out.println("(6): exit\n");
    }

    /**
     * Calls the provideDriverInfo method to search for a driver. Asks the user for the last name of the driver
     * and searches the appropriate list (either prospective or registered).
     * @param isRegisteredDriver boolean for whether the driver is registered or prospective.
     *                           True if registered. False if prospective.
     */
    private void runSearchDriver(boolean isRegisteredDriver) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the last name of the driver: ");
        String lastName = scanner.nextLine();

        if (isRegisteredDriver) {
            DriverSearch.provideDriverInfo(lastName, this.registeredDrivers);
        }
        else DriverSearch.provideDriverInfo(lastName, this.prospectiveDrivers);
    }

    /**
     * Returns the list of prospective drivers.
     * @return list of prospective drivers, as List of Driver.
     */
    public List<Driver> getProspectiveDrivers() {
        return prospectiveDrivers;
    }

    /**
     * Returns the list of registered drivers.
     * @return list of registered drivers, as List of Driver.
     */
    public List<Driver> getRegisteredDrivers() {
        return registeredDrivers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RideShareDriverValidatorSystem that = (RideShareDriverValidatorSystem) o;
        return Objects.equals(prospectiveDrivers, that.prospectiveDrivers) && Objects.equals(registeredDrivers, that.registeredDrivers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prospectiveDrivers, registeredDrivers);
    }

    @Override
    public String toString() {
        return "RideShareDriverValidatorSystem{" +
                "prospectiveDrivers=" + prospectiveDrivers +
                ", registeredDrivers=" + registeredDrivers +
                '}';
    }
}
