package com.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by v-fennev-ave on 7/10/15.
 */
public class connectionHelper {

    private WebDriver driver;
    private String browser;
    private String env;
    private Properties props = new Properties();
    private WebDriverWait wait;

    public connectionHelper() {

        InputStream in = this.getClass().getResourceAsStream("/config.properties");
        try {
            this.props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        browser = props.getProperty("browser");
        env = props.getProperty("env");

        //Select setup from config
        if ("firefox".equals(browser)) {
            setDriver(new FirefoxDriver());
        } else {
            //TO-DO other browsers
        }
        wait = new WebDriverWait(driver,5);

    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPage(String page) {
        this.driver.get(page);
    }
}
