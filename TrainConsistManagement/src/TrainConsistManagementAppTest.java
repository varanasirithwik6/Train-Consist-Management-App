import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;

public class TrainConsistManagementAppTest {

    private String[] sortNames(String[] arr) {
        String[] a = arr.clone();
        Arrays.sort(a);
        return a;
    }

    @Test
    public void testSort_BasicAlphabeticalSorting() {
        String[] input = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};

        assertArrayEquals(expected, sortNames(input));
    }

    @Test
    public void testSort_UnsortedInput() {
        String[] input = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};

        assertArrayEquals(expected, sortNames(input));
    }

    @Test
    public void testSort_AlreadySortedArray() {
        String[] input = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};

        assertArrayEquals(expected, sortNames(input));
    }

    @Test
    public void testSort_DuplicateBogieNames() {
        String[] input = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};

        assertArrayEquals(expected, sortNames(input));
    }

    @Test
    public void testSort_SingleElementArray() {
        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};

        assertArrayEquals(expected, sortNames(input));
    }
}