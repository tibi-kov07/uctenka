package cz.uctenka;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Spouštím tisk účtenky (v1.0.0) ===");
        StoreConfig config = new StoreConfig();
        Receipt receipt = new Receipt(config);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Zadejte název položky:");
            String name = scanner.nextLine().trim();
            if (name.equalsIgnoreCase("konec")) {
                break;
            }

            while (true) {
                try {
                    System.out.print("Zadejte cenu za jednotku (Kč): ");
                    double price = parsePrice(scanner.nextLine());

                    System.out.print("Zadejte množství: ");
                    int quantity = Integer.parseInt(scanner.nextLine().trim());

                    receipt.addItem(name, price, quantity);
                    System.out.println("Položka přidána.\n");
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Neplatné číslo. Zadejte hodnotu znovu.");
                }
            }
        }

        System.out.println("\n\n" + receipt.generatePrintout());
        scanner.close();
    }

    private static double parsePrice(String rawValue) {
        String normalizedValue = rawValue.trim().replace(',', '.');
        return Double.parseDouble(normalizedValue);
    }
}
