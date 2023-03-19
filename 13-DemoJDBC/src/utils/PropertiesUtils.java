package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {
    static Properties properties = null;
    public PropertiesUtils() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("D:\\FPT\\Training Thu Viec\\1. Java Core\\Fsoft Training - Java Core Source Code\\DemoJDBC\\src\\resources\\database.properties"));
    }
    public String getPropertyByName(String name) {
        return  properties.getProperty(name);
    }
}
