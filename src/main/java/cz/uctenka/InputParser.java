package cz.uctenka;

public final class InputParser {

    private InputParser() {
        throw new AssertionError("Utility class");
    }

    public static double parsePrice(String rawValue) throws NumberFormatException {
        String normalizedValue = normalizeNumber(rawValue);
        return Double.parseDouble(normalizedValue);
    }

    public static int parseQuantity(String rawValue) throws NumberFormatException {
        String normalizedValue = normalizeNumber(rawValue);
        int quantity = Integer.parseInt(normalizedValue);

        if (quantity <= 0) {
            throw new NumberFormatException("Množství musí být kladné číslo.");
        }

        return quantity;
    }

    private static String normalizeNumber(String rawValue) {
        if (rawValue == null) {
            throw new NumberFormatException("Hodnota nesmí být null.");
        }

        String normalizedValue = rawValue.trim().replace(" ", "").replace(',', '.');
        if (normalizedValue.isEmpty()) {
            throw new NumberFormatException("Hodnota nesmí být prázdná.");
        }

        return normalizedValue;
    }
}
