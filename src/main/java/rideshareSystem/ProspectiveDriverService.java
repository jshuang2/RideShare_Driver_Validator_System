package rideshareSystem;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class ProspectiveDriverService represents a utility class that executes functionality on prospective drivers.
 */
public class ProspectiveDriverService {

    /**
     * Reads a JSON file with prospective drivers, adds the prospective drivers to a list of Driver, and returns it.
     * @param dataFileName file name for the JSON file.
     * @param jsonMapKey key of the map. Needed by Jackson to access the data.
     * @return a list of Driver objects, or an empty list if the file is not found.
     */
    public static List<Driver> addProspectiveDrivers(String dataFileName, String jsonMapKey) {

        List<Driver> prospectiveDrivers = new ArrayList<>();

        // Attempts to open the file
        try (InputStream input = ProspectiveDriverService.class.getClassLoader().getResourceAsStream(dataFileName)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + dataFileName + ".");
                return prospectiveDrivers;
            }

            ObjectMapper mapper = new ObjectMapper(); // Creates a mapper object that will help read the data as a map.
            mapper.registerModule(new JavaTimeModule()); // Allows Jackson to work with LocalDate

            // Data is read as a map and stored.
            Map<String, List<Driver>> map = mapper.readValue(input, new TypeReference<>() {
            });

            prospectiveDrivers = map.get(jsonMapKey); // Retrieves the list of driver values from the map.

        } catch (Exception e) {
            e.printStackTrace();
        }

        return prospectiveDrivers;
    }

    /**
     * Removes all prospective drivers from the list of prospective drivers.
     * @param prospectiveDrivers list of prospective drivers to be cleared, as a list of Driver.
     */
    public static void removeProspectiveDrivers(List<Driver> prospectiveDrivers) {
        prospectiveDrivers.clear();
    }

    /**
     * Prints all prospective drivers.
     * @param prospectiveDrivers prospective drivers to print, as List of Driver.
     */
    public static void printAllProspectiveDrivers(List<Driver> prospectiveDrivers) {

        if (prospectiveDrivers.isEmpty()) System.out.println("There are no prospective drivers.");

        prospectiveDrivers.forEach(System.out::println);
    }

}
