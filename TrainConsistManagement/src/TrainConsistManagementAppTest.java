import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrainConsistManagementAppTest {

    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }
    }

    @Test
    public void testException_ValidCapacityCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 72);

        assertEquals("Sleeper", bogie.type);
        assertEquals(72, bogie.capacity);
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_NegativeCapacityThrowsException() throws InvalidCapacityException {
        new PassengerBogie("Sleeper", -10);
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_ZeroCapacityThrowsException() throws InvalidCapacityException {
        new PassengerBogie("AC Chair", 0);
    }

    @Test
    public void testException_ExceptionMessageValidation() {
        try {
            new PassengerBogie("First Class", 0);
        } catch (InvalidCapacityException e) {
            assertEquals("Capacity must be greater than zero", e.getMessage());
        }
    }

    @Test
    public void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("First Class", 24);

        assertEquals("First Class", bogie.type);
        assertEquals(24, bogie.capacity);
    }

    @Test
    public void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        PassengerBogie bogie1 = new PassengerBogie("Sleeper", 72);
        PassengerBogie bogie2 = new PassengerBogie("AC Chair", 56);

        assertEquals("Sleeper", bogie1.type);
        assertEquals(72, bogie1.capacity);
        assertEquals("AC Chair", bogie2.type);
        assertEquals(56, bogie2.capacity);
    }
}