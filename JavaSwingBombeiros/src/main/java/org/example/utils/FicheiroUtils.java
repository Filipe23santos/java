package org.example.utils;

import org.example.Main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FicheiroUtils {
    /**
     * <p>Permite ler uma propriedade de um ficheiro properties</p>
     * @return String com o valor da chave
     */
    public static String readProperty(String property) {
        Properties properties = new Properties();
        try (InputStream inputStream = Main.class.getResourceAsStream("/config.properties")) {
            properties.load(inputStream);
            return properties.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
            return "";  // Return an empty string as a fallback
        }
    }

    /**
     * <p>Permite um conjunto de propriedades de um ficheiro properties</p>
     * @return Array de Strings com os valores das chaves
     */
    public static String[] readProperties(String[] keys) {
        Properties properties = new Properties();
        String[] values = new String[keys.length];

        try (InputStream inputStream = Main.class.getResourceAsStream("/config.properties")) {
            properties.load(inputStream);

            for (int i = 0; i < keys.length; i++) {
                String key = keys[i];
                values[i] = properties.getProperty(key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return values;
    }
}
