package pageObjects;

import common.Commands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelResultsPO extends Commands {

    private By resultsNoFlights = By.cssSelector("span[data-testid='resultPage-filters-text'] ~ span");
    private By quickSort = By.cssSelector("button[data-testid='result-quick-sort-button'] span");
    //table
    private By resultRow = By.cssSelector("div[data-testid='tripDetails-segment']");
    private By airlineName = By.cssSelector("div[data-testid='tripDetails-segment'] div img ~ div");
    private By originTime = By.cssSelector("div[data-testid='tripDetails-segment'] div[data-testid='trip-segment-origin-time']");
    private By segmentDuration = By.cssSelector("div[data-testid='tripDetails-segment']  p[data-testid='searchResults-segment-duration']");
    private By destinationTime = By.cssSelector("div[data-testid='tripDetails-segment']  div[data-testid='trip-segment-destination-time']");
    private By standardPrice = By.cssSelector("span[data-testid='result-trip-price-standard']");


    /**
     * Return the no of flights
     * @return  string noOfFlights
     * */
    public String getNumberOfResults(){
        return getText(resultsNoFlights).trim().replace(":", "");
    }

    /**
     * Returns a list of web elements
     */
    public List<WebElement> getAirlineNameRows() {
        List<WebElement> rows = Collections.emptyList();
        rows = findElements(airlineName);
        return rows;
    }

    /**
     * Returns a list of web elements
     */
    public List<WebElement> getStandardPriceRows() {
        List<WebElement> rows = Collections.emptyList();
        rows = findElements(standardPrice);
        return rows;
    }


    /**
     * Returns a Map of quick sort info
     */
    public Map<String, String> getQuickSortInfo() {
        Map<String, String> info = new HashMap<String, String>();
        List<WebElement> elements = Collections.emptyList();
        elements = findElements(quickSort);
        for (int i = 0; i < elements.size(); i += 2) {
            String[] texts = elements.get(i + 1).getText().replaceAll("\\W", "").split(".");
            info.put(elements.get(i).getText().trim(), texts[0]);
        }
        return info;
    }

}
