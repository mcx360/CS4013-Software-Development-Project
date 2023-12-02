import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The ModuleCSVReader class reads module data from a CSV file and creates Module objects.
 * It provides a method to read modules from a CSV file and store them in an ArrayList.
 */
public class ModuleCSVReader {

    private ArrayList<Module> modules;

    /**
     * Constructs a new ModuleCSVReader with an empty ArrayList to store modules.
     */
    public ModuleCSVReader() {
        this.modules = new ArrayList<>();
    }

    /**
     * Reads module data from a CSV file and creates Module objects.
     *
     * @param filePath  The path to the CSV file containing module data.
     * @param programme The associated programme to which the modules belong.
     * @return An ArrayList containing Module objects created from the CSV file.
     */
    public ArrayList<Module> readModulesFromCSV(String filePath, Programme programme) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            // Assuming CSV format: moduleMapCode,moduleName,moduleCode,credits,professor
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 5) {
                    int moduleMapCode = Integer.parseInt(parts[0].trim());
                    String moduleName = parts[1].trim();
                    String moduleCode = parts[2].trim();
                    int credits = Integer.parseInt(parts[3].trim());
                    String professor = parts[4].trim();

                    Module module = new Module(moduleMapCode, moduleName, moduleCode, credits, programme, professor);
                    modules.add(module);
                } else {
                    // Handle incorrect format or incomplete data in the CSV file
                    System.err.println("Invalid format in CSV file: " + line);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        return modules;
    }

    /**
     * Gets the ArrayList of modules read from the CSV file.
     *
     * @return An ArrayList containing Module objects.
     */
    public ArrayList<Module> getModules() {
        return modules;
    }
}
