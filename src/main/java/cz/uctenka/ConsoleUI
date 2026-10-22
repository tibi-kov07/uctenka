package cz.uctenka;

import java.util.Scanner;

public class ConsoleUI {

    private final Scanner scanner;
    private final Receipt receipt;

    public ConsoleUI(Receipt receipt) {
        this.receipt = receipt;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== Spouštím tisk účtenky (v1.0.0) ===");

        while (true) {
            System.out.print("Zadejte název položky: ");
            String name = scanner.nextLine().trim();

            if (name.equalsIgnoreCase("konec")) {
                break;
            }

            processItemInput(name);
        }

        printReceipt();
        scanner.close();
    }

    private void processItemInput(String name) {
        while (true) {
            try {
                System.out.print("Zadejte cenu za jednotku (Kč): ");
                double price = InputParser.parsePrice(scanner.nextLine());

                System.out.print("Zadejte množství: ");
                int quantity = InputParser.parseQuantity(scanner.nextLine());

                receipt.addItem(name, price, quantity);
                System.out.println("Položka přidána.\n");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Neplatné číslo. Zadejte hodnotu znovu.");
            }
        }
    }

    private void printReceipt() {
        System.out.println("\n\n" + receipt.generatePrintout());
    }
}
