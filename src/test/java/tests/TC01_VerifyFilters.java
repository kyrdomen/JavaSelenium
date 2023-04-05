package tests;

import base.TestBase;
import businessObjects.TravelBO;
import businessObjects.TravelResultsBO;
import dtos.Filters;
import dtos.Travel;
import enums.Airlines;
import org.testng.annotations.Test;

public class TC01_VerifyFilters extends TestBase {
    TravelBO travelBO = new TravelBO();
    TravelResultsBO resultsBO = new TravelResultsBO();



    @Test(alwaysRun = true, description = "Verify minimum number of flights, when default filters are selected")
    public void testStep_1() {
        loadPreconditionsStep1();
        resultsBO.verifyMinNumberOfFlights(200);
    }

    @Test(alwaysRun = true, description = "Filter with specific airline, price range, travel duration. Verify results include only specific company", dependsOnMethods = "testStep_1" )
    public void testStep_2() {
        loadPreconditionsStep2();
        resultsBO.verifyAirlineName(Airlines.KLM.get());
    }

    @Test(alwaysRun = true, description = "Filter with specific airline, price range, travel duration. Verify results include only price into the requested range (MIN)", dependsOnMethods = "testStep_2" )
    public void testStep_3() {
        resultsBO.verifyMinimumFlightCost();
    }

    @Test(alwaysRun = true, description = "Filter with specific airline, price range, travel duration. Verify results include only price into the requested range (MAX)", dependsOnMethods = "testStep_3" )
    public void testStep_4() {
        resultsBO.verifyMaximumflightCost();
    }


    /* Search for a Return Travel Ath - Helsinki , 1 person , economy */
    public void loadPreconditionsStep1(){
        Travel travelReturn = Travel.builder().build();
        travelBO.searchForTravel(travelReturn);
    }

    public void loadPreconditionsStep2(){
        Filters multipleFilters = Filters.builder().build();
        resultsBO.filterResults(multipleFilters);
    }

}
