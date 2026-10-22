package cz.uctenka;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReceiptTest {

    @Test
    public void testCalculateTotal() {
        StoreConfig mockConfig = new StoreConfig() {
            @Override public String getName() { return "Test Shop"; }
            @Override public String getAddress() { return "Test Address"; }
            @Override public String getIco() { return "00000000"; }
            @Override public String getDic() { return "CZ00000000"; }
        };

        Receipt receipt = new Receipt(mockConfig);
        receipt.addItem("Rohlík", 3.0, 5);
        receipt.addItem("Mléko", 25.0, 2);
        receipt.addItem("Kuřecí prsa", 60.0, 1);
        receipt.addItem("Pasta na zuby", 45.0, 1);

        assertEquals(65.0, receipt.calculateTotal(), 0.001);
    }
}
