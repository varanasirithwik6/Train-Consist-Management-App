import java.util.Scanner;
import java.util.regex.Pattern;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("UC11 - Validate Train ID and Cargo Code");
        System.out.println("======================================\n");

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        String trainIdRegex = "TRN-\\d{4}";
        String cargoCodeRegex = "PET-[A-Z]{2}";

        boolean isTrainIdValid = Pattern.matches(trainIdRegex, trainId);
        boolean isCargoCodeValid = Pattern.matches(cargoCodeRegex, cargoCode);

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainIdValid);
        System.out.println("Cargo Code Valid: " + isCargoCodeValid);

        System.out.println("\nUC11 validation completed...");
    }
}