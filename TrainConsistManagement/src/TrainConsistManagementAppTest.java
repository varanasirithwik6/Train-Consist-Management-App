import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrainConsistManagementAppTest {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    private List<Bogie> getBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Passenger", 72));
        bogies.add(new Bogie("Passenger", 56));
        bogies.add(new Bogie("Passenger", 24));
        bogies.add(new Bogie("Passenger", 70));
        bogies.add(new Bogie("Passenger", 90));
        return bogies;
    }

    @Test
    public void testLoopFilteringLogic() {
        List<Bogie> result = new ArrayList<>();

        for (Bogie b : getBogies()) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }

        assertEquals(3, result.size());
    }

    @Test
    public void testStreamFilteringLogic() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(3, result.size());
    }

    @Test
    public void testLoopAndStreamResultsMatch() {
        List<Bogie> loopResult = new ArrayList<>();

        for (Bogie b : getBogies()) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        List<Bogie> streamResult = getBogies().stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    public void testExecutionTimeMeasurement() {
        long start = System.nanoTime();

        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        long end = System.nanoTime();

        assertTrue((end - start) > 0);
        assertEquals(3, result.size());
    }

    @Test
    public void testLargeDatasetProcessing() {
        List<Bogie> bogies = new ArrayList<>();

        for (int i = 1; i <= 10000; i++) {
            bogies.add(new Bogie("Passenger", i % 100));
        }

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertTrue(result.size() > 0);
    }
}