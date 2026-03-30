import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // Welcome banner
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================\n");

        // Create empty train consist
        List<String> trainConsist = new ArrayList<>();

        // Display initial details
        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count : " + trainConsist.size());
        System.out.println("Current Train Consist : " + trainConsist);

        System.out.println("\nSystem ready for operations...");
    }
}