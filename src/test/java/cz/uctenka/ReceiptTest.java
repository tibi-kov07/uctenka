package cz.uctenka;

public class Main {
    public static void main(String[] args) {
        StoreConfig config = new StoreConfig();
        Receipt receipt = new Receipt(config);
        ConsoleUI consoleUI = new ConsoleUI(receipt);
        consoleUI.start();
    }
}
