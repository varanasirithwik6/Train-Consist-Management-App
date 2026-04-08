import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrainConsistManagementAppTest {

    String trainIdRegex = "TRN-\\d{4}";
    String cargoCodeRegex = "PET-[A-Z]{2}";

    @Test
    public void testRegex_ValidTrainID() {
        assertTrue(Pattern.matches(trainIdRegex, "TRN-1234"));
    }

    @Test
    public void testRegex_InvalidTrainIDFormat() {
        assertFalse(Pattern.matches(trainIdRegex, "TRAIN12"));
        assertFalse(Pattern.matches(trainIdRegex, "TRN12A"));
        assertFalse(Pattern.matches(trainIdRegex, "1234-TRN"));
    }

    @Test
    public void testRegex_ValidCargoCode() {
        assertTrue(Pattern.matches(cargoCodeRegex, "PET-AB"));
    }

    @Test
    public void testRegex_InvalidCargoCodeFormat() {
        assertFalse(Pattern.matches(cargoCodeRegex, "PET-ab"));
        assertFalse(Pattern.matches(cargoCodeRegex, "PET123"));
        assertFalse(Pattern.matches(cargoCodeRegex, "AB-PET"));
    }

    @Test
    public void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(Pattern.matches(trainIdRegex, "TRN-123"));
        assertFalse(Pattern.matches(trainIdRegex, "TRN-12345"));
    }

    @Test
    public void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(Pattern.matches(cargoCodeRegex, "PET-ab"));
        assertFalse(Pattern.matches(cargoCodeRegex, "PET-aB"));
    }

    @Test
    public void testRegex_EmptyInputHandling() {
        assertFalse(Pattern.matches(trainIdRegex, ""));
        assertFalse(Pattern.matches(cargoCodeRegex, ""));
    }

    @Test
    public void testRegex_ExactPatternMatch() {
        assertFalse(Pattern.matches(trainIdRegex, "TRN-1234XYZ"));
        assertFalse(Pattern.matches(cargoCodeRegex, "PET-ABCD"));
    }
}