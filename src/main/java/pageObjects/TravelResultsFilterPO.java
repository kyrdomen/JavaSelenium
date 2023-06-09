package pageObjects;

import common.Commands;
import common.LocatorsUtilities;
import enums.NumberOfStops;
import enums.Sliders;
import enums.TravelKind;
import org.openqa.selenium.By;

public class TravelResultsFilterPO extends Commands {

    enum Locators implements LocatorsUtilities {
        airlineName("label[title=''{0}'']");
        private final String myLocator;

        Locators(String locator) {
            myLocator = locator;
        }

        public String getLocator() {
            return myLocator;
        }
    }

    private By filterToggleButton = By.cssSelector("button[data-testid='resultPage-toggleFiltersButton-button']");
    private By resetFiltersButton = By.cssSelector("button[data-testid='filtersForm-resetFilters-button']");
    private By applyFiltersButton = By.cssSelector("button[data-testid='filtersForm-applyFilters-button']");
    private By filterScreen = By.cssSelector("div[data-testid='resultPage-searchFilters-content']");

    //stops
    private By directStopButton = By.cssSelector("label[data-testid='MAX_STOPS-direct']");
    private By maxOneStopButton = By.cssSelector("label[data-testid='MAX_STOPS-max1']");
    private By allStopsButton = By.cssSelector("label[data-testid='MAX_STOPS-all']");

    //price
    private By priceSliderMin = By.cssSelector("div[data-testid='resultPage-PRICEFilter-content'] div[data-testid='handle-0']");
    private By priceSliderMax = By.cssSelector("div[data-testid='resultPage-PRICEFilter-content'] div[data-testid='handle-1']");
    private By maxPriceValue = By.cssSelector("div.slider-tracks ~ div ~ div");
    private By minPriceValue = By.cssSelector("div.slider-tracks ~ div");

    //airlines
    private By clearAllAirlines = By.cssSelector("div[data-testid='resultPage-AIRLINESFilter-content'] span:nth-child(1)");
    private By selectAllAirlines = By.cssSelector("div[data-testid='resultPage-AIRLINESFilter-content'] span:nth-child(2)");
    private By inputAirline = By.cssSelector("input");

    //travel time
    private By travelTimeSlider = By.cssSelector("div[data-testid='resultPage-TRAVEL_TIMEFilter-content'] div[data-testid='handle-0']");

    //outbound - inbound flight times
    private By departureOutRadio = By.cssSelector("input#departure-0");
    private By arrivalOutRadioButton = By.cssSelector("input#arrival-0");
    private By outSliderMin = By.cssSelector("div[data-testid='resultPage-departureArrivalFilter-departure0-slider'] div[data-testid='handle-0']");
    private By outSliderMax = By.cssSelector("div[data-testid='resultPage-departureArrivalFilter-departure0-slider'] div[data-testid='handle-1']");

    private By departureInRadio = By.cssSelector("input#departure-1");
    private By arrivalInRadioButton = By.cssSelector("input#arrival-1");
    private By inSliderMin = By.cssSelector("div[data-testid='resultPage-departureArrivalFilter-departure1-slider'] div[data-testid='handle-0']");
    private By inSliderMax = By.cssSelector("div[data-testid='resultPage-departureArrivalFilter-departure1-slider'] div[data-testid='handle-1']");


    /***
     * Open filter results screen from toggle button
     * @return
     */
    public TravelResultsFilterPO openFilterResults() {
        pressAndWaitForElement(filterToggleButton, filterScreen);
        return this;
    }

    /***
     * Reset Filters
     * @return
     */
    public TravelResultsFilterPO resetFilters() {
        press(resetFiltersButton);
        return this;
    }

    /***
     * Apply Filters
     * @return
     */
    public TravelResultsFilterPO applyFilters() {
        pressAndWaitForElementToDisappear(applyFiltersButton, filterScreen);
        return this;
    }

    /***
     * Get max Price from the filters ui
     * @return
     */
    public double getMaxPrice() {
        openFilterResults();
        Double price = transformPriceTextToDouble(maxPriceValue);
        applyFilters();
        return price;
    }

    /***
     * Transform Price text to double
     * @return
     */
    public double transformPriceTextToDouble(By locator){
        String texts = getText(locator).replaceAll("[^A-Za-z0-9()\\[\\]\\.]", "").replace("CA","");
        return Double.parseDouble(texts);
    }

    /***
     * Transform Price text to double
     * @return
     */
    public double transformPriceTextToDouble(String originalText){
        String texts = originalText.replaceAll("[^A-Za-z0-9()\\[\\]\\.]", "").replace("CA","");
        return Double.parseDouble(texts);
    }

    /***
     * Get min Price from the ui
     * @return
     */
    public Double getMinPrice() {
        openFilterResults();
        Double price = transformPriceTextToDouble(minPriceValue);
        applyFilters();
        return price;
    }

    /***
     * Select Stop Flight
     * @return
     */
    public TravelResultsFilterPO selectFlightStops(NumberOfStops numberOfStops) {
        switch (numberOfStops) {
            case NonStopFlights:
                selectNonStopFlight();
                break;
            case All:
                selectAllStopsButton();
                break;
            case OneStop:
                selectMaxOneStopButton();
                break;
            default:
        }
        return this;
    }

    /***
     * Select Non Stop Flight
     * @return
     */
    public TravelResultsFilterPO selectNonStopFlight() {
        press(directStopButton);
        return this;
    }

    /***
     * Select All Stops Flight
     * @return
     */
    public TravelResultsFilterPO selectAllStopsButton() {
        press(allStopsButton);
        return this;
    }

    /***
     * Select Max One Stop Flight
     * @return
     */
    public TravelResultsFilterPO selectMaxOneStopButton() {
        press(maxOneStopButton);
        return this;
    }


    /***
     * Clear All Airlines
     * @return
     */
    public TravelResultsFilterPO clickClearAllAirlines() {
        press(clearAllAirlines);
        return this;
    }

    /***
     * Select All Airlines
     * @return
     */
    public TravelResultsFilterPO selectAllAirlines() {
        press(selectAllAirlines);
        return this;
    }

    /***
     * Select Arrival Radio Button
     * @return
     */
    public TravelResultsFilterPO selectArrivalForTimes(TravelKind kind) {
        switch (kind) {
            case Inbound:
                press(arrivalInRadioButton);
                break;
            case Outbound:
                press(arrivalOutRadioButton);
                break;
            default:
        }
        return this;
    }


    /**
     * Slide elements
     *
     * @param slider
     * @param xOffset
     * @param yOffset
     * @return
     */
    public TravelResultsFilterPO slideFilters(Sliders slider, int xOffset, int yOffset) {
            switch (slider) {
                case minPrice:
                    slideElement(priceSliderMin, xOffset, yOffset);
                    break;
                case maxPrice:
                    slideElement(priceSliderMax, xOffset, yOffset);
                    break;
                case travelTime:
                    slideElement(travelTimeSlider, xOffset, yOffset);
                    break;
                case fromDepartureMin:
                    slideElement(outSliderMin, xOffset, yOffset);
                    break;
                case returnArrivalMax:
                    slideElement(inSliderMax, xOffset, yOffset);
                    break;
                default:
            }
        return this;
    }

    /**
     * Select airline
     *
     * @param name
     */
    public TravelResultsFilterPO selectAirline(String name) {
        clickClearAllAirlines();
        pressWebElementRelativeLocator(inputAirline, Locators.airlineName.getWithParams(name));
        return this;
    }

}
