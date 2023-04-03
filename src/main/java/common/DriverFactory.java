package common;

import org.openqa.selenium.WebDriver;


public class DriverFactory {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    /**
     * Getter for driver
     */
    public static WebDriver getWebDriver() {
        return webDriver.get();
    }

    /**
     * Setter for driver
     */
    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

}
