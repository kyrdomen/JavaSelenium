package common;


import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.locators.RelativeLocator.with;


import java.time.Duration;
import java.util.List;

public class Commands {

    private int waitForElement = 10;


    /**
     * Click element
     *
     * @param locator
     */
    public void press(By locator) {
        waitForElement(locator);
        DriverFactory.getWebDriver().findElement(locator).click();
    }

    /**
     * Press Enter
     *
     * @param locator
     */
    public void pressEnter(By locator) {
        DriverFactory.getWebDriver().findElement(locator).sendKeys(Keys.ENTER);
    }

    /**
     * Input text
     *
     * @param locator
     * @param text
     */
    public void sendKeys(By locator, String text) {
        waitForElement(locator);
        DriverFactory.getWebDriver().findElement(locator).sendKeys(text);
    }

    /**
     * Clear text
     *
     * @param locator
     */
    public void clear(By locator) {
        DriverFactory.getWebDriver().findElement(locator).clear();
    }

    /**
     * Get text
     *
     * @param locator
     * @return
     */
    public String getText(By locator) {
        waitForElement(locator);
        return DriverFactory.getWebDriver().findElement(locator).getText().trim();
    }

    /**
     * Input text by first clear the field
     *
     * @param locator
     * @param value
     */
    public void input(By locator, String value) {
        WebElement element = waitForElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    /**
     * Find elements
     * Returns a list of the elements
     *
     * @param locator
     */
    public List<WebElement> findElements(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getWebDriver(), Duration.ofSeconds(waitForElement), Duration.ofMillis(100L));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    /**
     * Refresh page
     */
    public void refreshPage() {
        Log.info("Refresh page...");
        DriverFactory.getWebDriver().navigate().refresh();
    }

    /**
     * Get number of rows on table
     *
     * @param locator
     */
    public int getNumberOfTotalRows(By locator) {
        waitForElement(locator);
        return DriverFactory.getWebDriver().findElement(locator).findElements(By.cssSelector("tbody tr")).size();
    }

    /**
     * Get number of columns on table
     *
     * @param locator
     */
    public int getNumberOfTotalColumns(By locator) {
        waitForElement(locator);
        return DriverFactory.getWebDriver().findElement(locator).findElements(By.cssSelector("tbody tr:nth-child(1) td")).size();
    }


    /**
     * Get number of elements match locator
     *
     * @param locator
     */
    public int getNumberOfElementsMatchLocator(By locator) {
        waitForElement(locator);
        return DriverFactory.getWebDriver().findElements(locator).size();
    }

    /**
     * Wait for element
     *
     * @param locator
     * @param waitSeconds
     */
    public WebElement waitForElement(By locator, long waitSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getWebDriver(), Duration.ofSeconds(waitSeconds), Duration.ofMillis(100L));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait for element
     *
     * @param locator
     */
    public WebElement waitForElement(By locator) {
        return waitForElement(locator, waitForElement);
    }

    /**
     * Wait for element to be invisible
     *
     * @param locator
     * @param waitSeconds
     */
    public void waitForElementInvisibility(By locator, long waitSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getWebDriver(), Duration.ofSeconds(waitSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Wait for element to be invisible
     *
     * @param locator
     */
    public void waitForElementInvisibility(By locator) {
        waitForElementInvisibility(locator, waitForElement);
    }

    /**
     * Wait for element to be present
     *
     * @param locator
     * @param waitSeconds
     */
    public WebElement waitForElementPresence(By locator, long waitSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getWebDriver(), Duration.ofSeconds(waitSeconds), Duration.ofMillis(100L));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Wait for element to be present
     *
     * @param locator
     */
    public WebElement waitForElementPresence(By locator) {
        return waitForElementPresence(locator, waitForElement);
    }

    /**
     * Press and wait for element
     *
     * @param pressLocator
     * @param elementToWaitLocator
     * @param waitSeconds
     */
    public void pressAndWaitForElement(By pressLocator, By elementToWaitLocator, long waitSeconds) {
        press(pressLocator);
        waitForElement(elementToWaitLocator, waitSeconds);
    }

    /**
     * Press and wait for element
     *
     * @param pressLocator
     * @param elementToWaitLocator
     */
    public void pressAndWaitForElement(By pressLocator, By elementToWaitLocator) {
        pressAndWaitForElement(pressLocator, elementToWaitLocator, waitForElement);
    }


    /**
     * Press and wait for element to disappear
     *
     * @param pressLocator
     * @param elementToWaitLocator
     */
    public void pressAndWaitForElementToDisappear(By pressLocator, By elementToWaitLocator){
        press(pressLocator);
        waitForElementToDisappear(elementToWaitLocator, waitForElement);
    }

    /**
     * Wait for element to disappear
     *
     * @param locator
     * @param waitSeconds
     */
    public Boolean waitForElementToDisappear(By locator, long waitSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getWebDriver(), Duration.ofSeconds(waitSeconds), Duration.ofMillis(100L));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public Actions getBuilder() {
        return new Actions(DriverFactory.getWebDriver());
    }

    /**
     * Mouse Over
     *
     * @param locator
     */
    public void mouseOver(By locator) {
        getBuilder().moveToElement(waitForElement(locator)).perform();
    }

    /**
     * Mouse up
     *
     * @param locator
     */
    public void mouseUp(By locator) {
        getBuilder().release(waitForElement(locator)).perform();
    }

    /**
     * Mouse down
     *
     * @param locator
     */
    public void mouseDown(By locator) {
        getBuilder().clickAndHold(waitForElement(locator)).perform();
    }

    /**
     * Double click
     *
     * @param locator
     */
    public void doubleClick(By locator) {
        getBuilder().doubleClick(waitForElement(locator)).perform();
    }

    /**
     * Slide Element
     *
     * @param locator
     * @param xOffset
     * @param yOffset
     */
    public void slideElement(By locator, int xOffset, int yOffset) {
        WebElement slider = DriverFactory.getWebDriver().findElement(locator);
        getBuilder().dragAndDropBy(slider, xOffset, yOffset).perform();
    }

    public void pressWebElementRelativeLocator(By locator, By relativeLocator){
        WebElement element = DriverFactory.getWebDriver().findElement(with(locator).near(relativeLocator));
        element.click();
    }
}
