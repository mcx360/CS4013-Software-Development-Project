import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ModuleCSVReader {
    private ArrayList<Module> modules;

    public ModuleCSVReader() {
        this.modules = new ArrayList<>();
    }

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

    public ArrayList<Module> getModules() {
        return modules;
    }

    public static void main(String[] args) {
        // Example usage:
        
        Programme ComputerScience = new Programme("ComputerScience", 4, 8);
        ModuleCSVReader csvReader = new ModuleCSVReader();
        ArrayList<Module> modules = csvReader.readModulesFromCSV("CS4013-Software-Development-Project\\src\\modules.csv", ComputerScience);
        

        // Do something with the modules, e.g., print information
        for (Module module : modules) {
            System.out.println(module.toString());
        }
    }
}

