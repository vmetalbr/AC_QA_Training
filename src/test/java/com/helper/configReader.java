package com.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by v-fennev-ave on 7/10/15.
 */
public class ConfigReader {
    public static Properties configProp = new Properties();

    public static void main(String[] args) {
        ConfigReader read = new ConfigReader();
        read.loadProps1();
        System.out.println(showBrowser(configProp));
    }

    public void loadProps1() {
            InputStream in = this.getClass().getResourceAsStream("/config.properties");
            try {
                configProp.load(in);

            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public Properties getReader() {
        return configProp;
    }

    public static String showBrowser(Properties prop) {
        return prop.getProperty("browser");
    }
}
