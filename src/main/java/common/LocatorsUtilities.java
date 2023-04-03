package common;


import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

public interface  LocatorsUtilities {

    /** returns a String that represents the locator for the element*/
    String getLocator();

    /**
     * Logs the usage of the locator using the logUsage() method
     * and returns the locator string by calling getLocator().
     * */
    default String get() {
        logUsage();
        return getLocator();
    }

    /**
     * Logs the usage of the locator using the logUsage() method, formats the locator string with the provided parameters
     * using MessageFormat.format(), and returns the formatted string
     */
    default By getWithParams(Object... params) {
        logUsage();
        return new By.ByCssSelector(MessageFormat.format(getLocator(), params));
    }

    default void logUsage() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("Using {}", getLocator());
    }
}


