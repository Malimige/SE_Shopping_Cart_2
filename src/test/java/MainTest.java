import org.junit.jupiter.api.Test;
import java.util.Locale;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testItemTotal() {
        assertEquals(20, Main.calculateItemTotal(10, 2));
    }

    @Test
    void testCartTotal() {
        double[] prices = {10, 5};
        int[] quantities = {2, 3};
        assertEquals(35, Main.calculateCartTotal(prices, quantities));
    }

    @Test
    void testZeroQuantity() {
        assertEquals(0, Main.calculateItemTotal(10, 0));
    }

    @Test
    void testZeroPrice() {
        assertEquals(0, Main.calculateItemTotal(0, 5));
    }

    @Test
    void testSingleItemCart() {
        double[] prices = {10};
        int[] quantities = {2};
        assertEquals(20, Main.calculateCartTotal(prices, quantities));
    }

    @Test
    void testEmptyCart() {
        double[] prices = {};
        int[] quantities = {};
        assertEquals(0, Main.calculateCartTotal(prices, quantities));
    }

    @Test
    void testItemTotalWithDecimals() {
        assertEquals(17.4, Main.calculateItemTotal(8.7, 2), 0.001);
    }

    @Test
    void testCartTotalWithDecimals() {
        double[] prices = {10.5, 5.25};
        int[] quantities = {2, 4};
        assertEquals(42.0, Main.calculateCartTotal(prices, quantities), 0.001);
    }

    @Test
    void testLargeNumbers() {
        assertEquals(1000000, Main.calculateItemTotal(1000, 1000));
    }

    @Test
    void testVerySmallDecimals() {
        assertEquals(0.002, Main.calculateItemTotal(0.001, 2), 0.0001);
    }

    @Test
    void testCartWithMixedValues() {
        double[] prices = {0, 10.99, 5.50};
        int[] quantities = {10, 1, 2};
        assertEquals(21.99, Main.calculateCartTotal(prices, quantities), 0.001);
    }

    @Test
    void testCartTotalSingleItem() {
        double[] prices = {15.99};
        int[] quantities = {1};
        assertEquals(15.99, Main.calculateCartTotal(prices, quantities), 0.001);
    }

    @Test
    void testCartTotalMultipleItemsDifferentQuantities() {
        double[] prices = {1, 2, 3, 4, 5};
        int[] quantities = {10, 20, 30, 40, 50};
        assertEquals(550, Main.calculateCartTotal(prices, quantities));
    }

    // ✅ UPDATED LOCALE TESTS (String instead of int)

    @Test
    void testLocaleEnglish() {
        Locale locale = Main.getLocale("EN");
        assertEquals("en", locale.getLanguage());
        assertEquals("US", locale.getCountry());
    }

    @Test
    void testLocaleFinnish() {
        Locale locale = Main.getLocale("FI");
        assertEquals("fi", locale.getLanguage());
        assertEquals("FI", locale.getCountry());
    }

    @Test
    void testLocaleSwedish() {
        Locale locale = Main.getLocale("SV");
        assertEquals("sv", locale.getLanguage());
        assertEquals("SE", locale.getCountry());
    }

    @Test
    void testLocaleJapanese() {
        Locale locale = Main.getLocale("JP");
        assertEquals("ja", locale.getLanguage());
        assertEquals("JP", locale.getCountry());
    }

    @Test
    void testLocaleArabic() {
        Locale locale = Main.getLocale("AR");
        assertEquals("ar", locale.getLanguage());
        assertEquals("AR", locale.getCountry());
    }

    @Test
    void testDefaultLocale() {
        Locale locale = Main.getLocale("UNKNOWN");
        assertEquals("en", locale.getLanguage());
        assertEquals("US", locale.getCountry());
    }

    @Test
    void testLocaleCaseSensitivity() {
        Locale locale1 = Main.getLocale("EN");
        Locale locale2 = Main.getLocale("en");
        assertEquals(locale1.getLanguage(), locale2.getLanguage());
    }

    @Test
    void testLocaleEmptyString() {
        Locale locale = Main.getLocale("");
        assertEquals("en", locale.getLanguage());
        assertEquals("US", locale.getCountry());
    }

    @Test
    void testLocaleNumbers() {
        Locale locale = Main.getLocale("123");
        assertEquals("en", locale.getLanguage());
        assertEquals("US", locale.getCountry());
    }

    // ❌ REMOVED: testMainExecution (no longer valid for GUI app)

}