package com.helper;

import cucumber.runtime.ScenarioResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by v-fennev-ave on 7/10/15.
 */
public class connectionHelper {

    private WebDriver driver;
    private String browser;
    private String env;
    private Properties props = new Properties();

    public connectionHelper() {

        InputStream in = this.getClass().getResourceAsStream("/config.properties");
        try {
            this.props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        browser = props.getProperty("browser");
        env = props.getProperty("env");
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

    public void setWait() {this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); }

    public void startDriver(){
        //Select setup from config
        if ("firefox".equals(browser)) {
            setDriver(new FirefoxDriver());
            setWait();
        } else {
            //TO-DO other browsers
        }
    }

    public void stopDriver() {  this.driver.quit(); }



    public void embedScreenshot(ScenarioResult scenario) {
        if (scenario.isFailed()) {
            try {
                final byte[] screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(new ByteArrayInputStream(screenshot), "image/png");
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
    }


}
