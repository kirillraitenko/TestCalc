import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pro.edme.MainCalc;

public class TestingCalc {

    @ParameterizedTest
    @CsvSource({
            "1 / 1 *1",
            "1 1",
            "1 +",
            " + 1",
    })
    public void testIllegalArgumentException(final String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> MainCalc.calc(input));
    }

    @ParameterizedTest
    @CsvSource({
            "11 / 1",
            "1 / 11",
    })
    public void testMoreThan10(final String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> MainCalc.calc(input));
    }

    @ParameterizedTest
    @CsvSource({
            "10 + 2, 12",
            "10 / 2, 5",
            "9 * 8, 72",
            "9 - 8, 1",
    })
    public void testCalc(String str, String result) {
        Assertions.assertEquals(result, MainCalc.calc(str));
    }

    @Test
    public void testDividedZero() {
        Assertions.assertThrows(java.lang.ArithmeticException.class, () -> MainCalc.calc("1 / 0"));
    }
}
