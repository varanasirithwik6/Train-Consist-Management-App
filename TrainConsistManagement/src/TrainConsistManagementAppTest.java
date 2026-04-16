import org.junit.Test;
import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    boolean binarySearch(String[] arr, String key) {
        java.util.Arrays.sort(arr);

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int res = key.compareTo(arr[mid]);

            if (res == 0) return true;
            else if (res > 0) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    @Test
    public void testFound() {
        assertTrue(binarySearch(new String[]{"BG101","BG205","BG309"}, "BG309"));
    }

    @Test
    public void testNotFound() {
        assertFalse(binarySearch(new String[]{"BG101","BG205"}, "BG999"));
    }

    @Test
    public void testSingleElement() {
        assertTrue(binarySearch(new String[]{"BG101"}, "BG101"));
    }

    @Test
    public void testEmptyArray() {
        assertFalse(binarySearch(new String[]{}, "BG101"));
    }
}