package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    // This class reads the configuration.properties file
    // Create Properties instance
    private static Properties properties;

    static {

        String path="configuration.properties";

        try {

            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);


            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getProperty(String key){
        return properties.getProperty(key);
    }


    public static void setProperties(String key, String newValue){
        properties.setProperty(key, newValue);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("configuration.properties");
            properties.store(fileOutputStream, null);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}