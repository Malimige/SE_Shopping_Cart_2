import java.util.Locale;

public class Main {

    // Method 1 - calculate single item total
    public static double calculateItemTotal(double price, int quantity) {
        return price * quantity;
    }

    // Method 2 - calculate cart total
    public static double calculateCartTotal(double[] prices, int[] quantities) {
        double total = 0;
        for (int i = 0; i < prices.length; i++) {
            total += calculateItemTotal(prices[i], quantities[i]);
        }
        return total;
    }

    // Method 3 - get locale
    public static Locale getLocale(String language) {
        return switch (language) {
            case "FI" -> new Locale("fi", "FI");
            case "SV" -> new Locale("sv", "SE");
            case "JP" -> new Locale("ja", "JP");
            case "AR" -> new Locale("ar", "AR");
            default -> new Locale("en", "US");
        };
    }
}