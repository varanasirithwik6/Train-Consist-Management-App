import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TrainConsistManagementAppTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    private List<Bogie> getBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70)
        );
    }

    @Test
    public void testReduce_TotalSeatCalculation() {
        int total = getBogies().stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(222, total);
    }

    @Test
    public void testReduce_MultipleBogiesAggregation() {
        int total = getBogies().stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(222, total);
    }

    @Test
    public void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72)
        );

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(72, total);
    }

    @Test
    public void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(0, total);
    }

    @Test
    public void testReduce_CorrectCapacityExtraction() {
        List<Integer> capacities = getBogies().stream()
                .map(b -> b.capacity)
                .collect(java.util.stream.Collectors.toList());

        assertEquals(4, capacities.size());
        assertEquals(Integer.valueOf(72), capacities.get(0));
        assertEquals(Integer.valueOf(56), capacities.get(1));
        assertEquals(Integer.valueOf(24), capacities.get(2));
        assertEquals(Integer.valueOf(70), capacities.get(3));
    }

    @Test
    public void testReduce_AllBogiesIncluded() {
        int total = getBogies().stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(222, total);
    }

    @Test
    public void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>(getBogies());

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(4, bogies.size());
        assertEquals(222, total);
    }
}