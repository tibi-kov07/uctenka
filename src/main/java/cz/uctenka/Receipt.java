package cz.uctenka;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private final StoreConfig storeConfig;
    private final List<Item> items = new ArrayList<>();

    public Receipt(StoreConfig storeConfig) {
        this.storeConfig = storeConfig;
    }

    public void addItem(String name, double price, int quantity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Název položky nesmí být prázdný.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Množství musí být větší než 0.");
        }

        items.add(new Item(name.trim(), BigDecimal.valueOf(price), quantity));
    }

    public double calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (Item item : items) {
            total = total.add(item.unitPrice.multiply(BigDecimal.valueOf(item.quantity)));
        }

        return total.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public String generatePrintout() {
        StringBuilder printout = new StringBuilder();
        printout.append("=== ").append(storeConfig.getName()).append(" ===\n");
        printout.append(storeConfig.getAddress()).append("\n");
        printout.append("IČO: ").append(storeConfig.getIco()).append("\n");
        printout.append("DIČ: ").append(storeConfig.getDic()).append("\n\n");

        if (items.isEmpty()) {
            printout.append("Žádné položky.");
            return printout.toString();
        }

        for (Item item : items) {
            BigDecimal lineTotal = item.unitPrice.multiply(BigDecimal.valueOf(item.quantity));
            printout.append(String.format("%-22s %8.2f x %3d = %8.2f Kč\n",
                    item.name,
                    item.unitPrice,
                    item.quantity,
                    lineTotal));
        }

        printout.append("\nCelkem: ").append(String.format("%.2f Kč", calculateTotal()));
        return printout.toString();
    }

    private static final class Item {
        private final String name;
        private final BigDecimal unitPrice;
        private final int quantity;

        private Item(String name, BigDecimal unitPrice, int quantity) {
            this.name = name;
            this.unitPrice = unitPrice;
            this.quantity = quantity;
        }
    }
}
