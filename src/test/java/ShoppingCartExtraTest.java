import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartExtraTest {

    @Test
    void testNegativePrice() {
        assertEquals(-20, Main.calculateItemTotal(-10, 2));
    }

    @Test
    void testNegativeQuantity() {
        assertEquals(-20, Main.calculateItemTotal(10, -2));
    }

    @Test
    void testBothNegative() {
        assertEquals(20, Main.calculateItemTotal(-10, -2));
    }

    @Test
    void testLargeValues() {
        assertEquals(1000000, Main.calculateItemTotal(1000, 1000));
    }

    @Test
    void testCartMultipleItems() {
        double[] prices = {10, 20, 30};
        int[] quantities = {1, 2, 3};
        assertEquals(140, Main.calculateCartTotal(prices, quantities));
    }

    @Test
    void testCartWithZeros() {
        double[] prices = {0, 10};
        int[] quantities = {5, 0};
        assertEquals(0, Main.calculateCartTotal(prices, quantities));
    }

    @Test
    void testLocaleAllOptions() {
        assertEquals("en", Main.getLocale("EN").getLanguage());
        assertEquals("fi", Main.getLocale("FI").getLanguage());
        assertEquals("sv", Main.getLocale("SV").getLanguage());
        assertEquals("ja", Main.getLocale("JP").getLanguage());
        assertEquals("ar", Main.getLocale("AR").getLanguage());
    }

    @Test
    void testLocaleFallback() {
        assertEquals("en", Main.getLocale("XYZ").getLanguage());
    }
}