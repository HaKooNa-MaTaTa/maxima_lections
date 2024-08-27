import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Run tests class - NumberUtil")
public class NumberUtilTest {

    private final NumberUtil numberUtil = new NumberUtil();

    @Nested
    @DisplayName("Test method isSimple:")
    class TestMethod_isSimple {

        @ParameterizedTest(name = "return <true> on {0}")
        @ValueSource(ints = {2, 3, 13, 17, 19, 31})
        @DisplayName("Test simple numbers:")
        public void testOnSimpleNumbers(int number) {
            assertTrue(numberUtil.isSimple(number));
        }

        @ParameterizedTest(name = "return <false> on {0}")
        @ValueSource(ints = {9, 15, 16, 64, 169})
        @DisplayName("Test not simple numbers:")
        public void testOnNotSimpleNumbers(int number) {
            assertFalse(numberUtil.isSimple(number));
        }

        @ParameterizedTest(name = "return IllegalArgumentException on {0}")
        @ValueSource(ints = {-10, 0})
        @DisplayName("Test exceptions:")
        public void isSimple_throwException(int number) {
            assertThrows(IllegalArgumentException.class, () -> numberUtil.isSimple(number));
        }
    }

    @Nested
    @DisplayName("Test method gcd:")
    class TestMethod_gcd {

        @ParameterizedTest(name = "for numbers {0} and {1} result - {2}")
        @CsvSource(value = {"9, 12, 3", "18, 12, 6", "16, 48, 16"})
        @DisplayName("Test gcd:")
        public void gcd(int a, int b, int expected) {
            assertEquals(expected, numberUtil.gcd(a, b));
        }
    }
}
