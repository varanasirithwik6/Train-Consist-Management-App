public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("UC20 - Exception Handling During Search\n");

        String[] bogieIds = {}; // empty array
        String searchId = "BG101";

        // Fail-fast check
        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        boolean found = false;

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Bogie found.");
        } else {
            System.out.println("Bogie not found.");
        }
    }
}

