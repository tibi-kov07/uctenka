package cz.uctenka;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StoreConfig {

    private final String name;
    private final String address;
    private final String ico;
    private final String dic;

    public StoreConfig() {
        Properties properties = new Properties();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("store.properties")) {
            if (inputStream == null) {
                throw new IllegalStateException("Soubor store.properties nebyl nalezen ve zdrojích aplikace.");
            }

            properties.load(inputStream);
        } catch (IOException exception) {
            throw new IllegalStateException("Nelze načíst konfiguraci obchodu.", exception);
        }

        this.name = properties.getProperty("store.name", "Obchod");
        this.address = properties.getProperty("store.address", "Neznámá adresa");
        this.ico = properties.getProperty("store.ico", "00000000");
        this.dic = properties.getProperty("store.dic", "CZ00000000");
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getIco() {
        return ico;
    }

    public String getDic() {
        return dic;
    }
}
