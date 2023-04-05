package businessObjects;

import dtos.Filters;
import enums.Sliders;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.TravelResultsFilterPO;
import pageObjects.TravelResultsPO;
import validator.Validator;

import java.util.List;
import java.util.Map;

public class TravelResultsBO extends Validator {
    protected TravelResultsPO resultsPO = new TravelResultsPO();
    protected TravelResultsFilterPO travelResultsFilterPO = new TravelResultsFilterPO();


    /**
     * Select filters
     *
     * @return
     */
    public TravelResultsBO filterResults (Filters filter){
        travelResultsFilterPO.openFilterResults();
        travelResultsFilterPO.selectFlightStops(filter.stops);
        travelResultsFilterPO.slideFilters(Sliders.minPrice, filter.priceMin, 0);
        travelResultsFilterPO.slideFilters(Sliders.maxPrice, filter.priceMax, 0);
        travelResultsFilterPO.slideFilters(Sliders.travelTime, filter.travelTimeMax, 0);
        travelResultsFilterPO.slideFilters(Sliders.fromDepartureMin, filter.fromMin, 0);
        travelResultsFilterPO.slideFilters(Sliders.returnDepartureMin, filter.toMin, 0);
        travelResultsFilterPO.selectAirline(filter.airline);
        travelResultsFilterPO.applyFilters();
        return this;
    }



    ///////////////////////////////////// Verifications ///////////////////////////////

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
     ** @return
     */
    public TravelResultsBO verifyMinimumFlightCost() {
        initSoftAssertions();
        List<WebElement> rows = resultsPO.getStandardPriceRows();
        Double expectedCost = travelResultsFilterPO.getMinPrice();
        for (int i = 0; i < rows.size(); i++) {
            Double price = travelResultsFilterPO.transformPriceTextToDouble(rows.get(i).getText());
            Assert.assertTrue(price > expectedCost, "TableRow: " + i + " Has Expected:" + expectedCost + "BUT found: " + price);
        }
        return this;
    }


    /**
     * Verify MAXIMUM cost
     ** @return
     */
    public TravelResultsBO verifyMaximumflightCost() {
        initSoftAssertions();
        List<WebElement> rows = resultsPO.getStandardPriceRows();
        Double expectedCost = travelResultsFilterPO.getMaxPrice();
        for (int i = 0; i < rows.size(); i++) {
            Double price = travelResultsFilterPO.transformPriceTextToDouble(rows.get(i).getText());
            Assert.assertTrue(price < expectedCost, "TableRow: " + i + " Has Expected:" + expectedCost + "BUT found: " + price);
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
