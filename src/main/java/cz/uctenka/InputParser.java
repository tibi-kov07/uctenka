package cz.uctenka;
 
public class InputParser {
 
    public static double parsePrice(String rawValue) throws NumberFormatException {

        String normalizedValue = rawValue.trim().replace(',', '.');

        return Double.parseDouble(normalizedValue);

    }
 
    public static int parseQuantity(String rawValue) throws NumberFormatException {

        return Integer.parseInt(rawValue.trim());

    }

}
 
