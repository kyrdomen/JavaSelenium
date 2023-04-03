package businessObjects;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.TravelResultsPO;
import validator.Validator;

import java.util.List;
import java.util.Map;

public class TravelResultsBO extends Validator {
    protected TravelResultsPO resultsPO = new TravelResultsPO();

    /**
     * Verify number of flights
     *
     * @return
     */
    public TravelResultsBO verifyNumberOfFlights(String expectedFlights) {
        hardValidate(resultsPO.getNumberOfResults(), expectedFlights);
        return this;
    }

    /**
     * Verify minimum number of flights
     *
     * @return
     */
    public TravelResultsBO verifyMinNumberOfFlights(Integer expectedFlights) {
        Assert.assertTrue(Integer.valueOf(resultsPO.getNumberOfResults()) > expectedFlights);
        return this;
    }

    /**
     * Verify airline name
     *
     * @param name
     * @return
     */
    public TravelResultsBO verifyAirlineName(String name) {
        initSoftAssertions();
        List<WebElement> rows = resultsPO.getAirlineNameRows();
        for (int i = 0; i < rows.size(); i++) {
            softValidate(rows.get(i).getText().trim(), name, "TableRow: " + i + " Has Expected:" + name + "BUT found: " + rows.get(i).getText());
        }
        validateAll();
        return this;
    }

    /**
     * Verify minimum cost
     *
     * @param cost
     * @return
     */
    public TravelResultsBO verifyMinimumFlightCost(Integer cost) {
        initSoftAssertions();
        List<WebElement> rows = resultsPO.getStandardPriceRows();
        for (int i = 0; i < rows.size(); i++) {
            String[] texts = rows.get(i).getText().replaceAll("\\W", "").trim().split(".");
            Integer price = Integer.valueOf(texts[0]);
            Assert.assertTrue(price > cost, "TableRow: " + i + " Has Expected:" + cost + "BUT found: " + price);
        }
        return this;
    }

    /**
     * Verify Quick Sort Info
     *
     * @param minCost
     * @return
     */
    public TravelResultsBO verifyQuickSortInfo(Integer minCost) {
        Map<String, String> actualData = resultsPO.getQuickSortInfo();
        actualData.forEach((k, v) ->
            Assert.assertTrue(Integer.valueOf(v) > minCost,  k + " Has min Expected:" + minCost + "BUT found: " + v));
        return this;
    }


}
