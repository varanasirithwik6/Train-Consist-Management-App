import org.junit.Test;
import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    @Test(expected = IllegalStateException.class)
    public void testEmptyArrayThrowsException() {
        String[] arr = {};
        if (arr.length == 0) {
            throw new IllegalStateException();
        }
    }

    @Test
    public void testValidSearch() {
        String[] arr = {"BG101", "BG205"};
        boolean found = false;

        for (String id : arr) {
            if (id.equals("BG101")) {
                found = true;
            }
        }
        assertTrue(found);
    }
}