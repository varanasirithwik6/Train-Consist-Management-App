import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC5 - Preserve Insertion Order of Bogies");
        System.out.println("======================================\n");

        // Create LinkedHashSet (order + no duplicates)
        Set<String> formation = new LinkedHashSet<>();

        // ADD bogies
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // Duplicate (will be ignored)
        formation.add("Sleeper");

        // Display result
        System.out.println("Final Train Formation:");
        System.out.println(formation);

        System.out.println("\nNote: LinkedHashSet preserves order and removes duplicates.");

        System.out.println("\nUC5 formation setup completed...");
    }
}