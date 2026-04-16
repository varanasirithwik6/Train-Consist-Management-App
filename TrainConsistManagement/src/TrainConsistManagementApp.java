import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("UC19 - Binary Search for Bogie ID\n");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Sort first (IMPORTANT)
        Arrays.sort(bogieIds);

        String key = "BG309";

        int low = 0;
        int high = bogieIds.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = (low + high) / 2;

            int result = key.compareTo(bogieIds[mid]);

            if (result == 0) {
                found = true;
                break;
            } else if (result > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (found) {
            System.out.println("Bogie " + key + " found using Binary Search.");
        } else {
            System.out.println("Bogie not found.");
        }
    }
}