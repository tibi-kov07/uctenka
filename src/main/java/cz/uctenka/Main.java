package cz.uctenka;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Spouštím tisk účtenky (v1.0.0) ===");
        StoreConfig config = new StoreConfig();
        Receipt receipt = new Receipt(config);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Zadejte název položky (nebo 'konec' pro vydání účtenky): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("konec")) {
                break;
            }

            System.out.print("Zadejte cenu za jednotku (Kč): ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Zadejte množství: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            receipt.addItem(name, price, quantity);
            System.out.println("Položka přidána.\n");
        }

        System.out.println("\n\n" + receipt.generatePrintout());
    }
}
