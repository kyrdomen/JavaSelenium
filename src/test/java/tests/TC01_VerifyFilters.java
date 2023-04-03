package tests;

import base.TestBase;
import businessObjects.TravelBO;
import businessObjects.TravelResultsBO;
import dtos.Travel;
import org.testng.annotations.Test;

public class TC01_VerifyFilters extends TestBase {
    TravelBO travelBO = new TravelBO();
    TravelResultsBO resultsBO = new TravelResultsBO();


    @Test(alwaysRun = true, description = "Verify results with default filters")
    public void testStep_1() {
        searchFlight();

    }


    /**
     * Search for a Return Travel
     * Ath - Helsinki , 1 person , economy
     * */
    private void searchFlight() {
        Travel travelReturn = new Travel();
        travelBO.searchForTravel(travelReturn);
    }
}
