package pageObjects;

import common.Commands;
import common.LocatorsUtilities;
import org.openqa.selenium.By;

public class TravelFilterPO extends Commands {
    enum Locators implements LocatorsUtilities {
        flightDayDate("div.DayPicker-Day[aria-label=''{0}'']");
        private final String myLocator;

        Locators(String locator) {
            myLocator = locator;
        }

        public String getLocator() { return myLocator; }
    }

    //Locators
    private By returnRadioButton = By.cssSelector("label[data-testid='searchForm-return-radio-label'] div");
    private By oneWayRadioButton = By.cssSelector("label[data-testid='searchForm-oneWay-radio-label'] div");
    private By multiCityRadioButton = By.cssSelector("label[data-testid='searchForm-multiStop-radio-label'] div");
    private By buttonAddTrip = By.cssSelector("button[data-testid='searchForm-multiStop-addTrip-button']");
    private By originInput = By.cssSelector("input#searchForm-singleBound-origin-input");
    private By destinationInput = By.cssSelector("input#searchForm-singleBound-destination-input");
    private By departureDateInput = By.cssSelector("input[aria-label='Departure']");
    private By returnDateInput = By.cssSelector("input[aria-label='Return']");
    private By citiesDropdown = By.cssSelector("div[data-testid='etiDropdownOption']");
    private By searchFlightsButton = By.cssSelector("button[data-testid='searchForm-searchFlights-button']");

    //Calendar Locators
    private By dayPicker = By.cssSelector("div.DayPicker");
    private By chooseMonthArrow = By.cssSelector("button[data-testid='searchForm-nextMonth-input']");
    private By calendarMonthText = By.cssSelector("div.DayPicker-Caption");

    /**
     * Select Return travel
     *
     * @return
     */
    public TravelFilterPO selectReturnTravel(){
        press(returnRadioButton);
       return this;
    }

    /**
     * Select One way travel
     *
     * @return
     */
    public TravelFilterPO selectOneWayTravel(){
        press(oneWayRadioButton);
        return this;
    }

    /**
     * Select MultiCity
     *
     * @return
     */
    public TravelFilterPO selectMultiCityTravel(){
        press(multiCityRadioButton);
        return this;
    }

    /**
     * Input origin(from) city
     *
     * @return
     */
    public TravelFilterPO inputOriginCity(String country) {
        input(originInput, country);
        waitForElement(citiesDropdown);
        pressEnter(originInput);
        return this;
    }


    /**
     * Input destination city
     *
     * @return
     */
    public TravelFilterPO inputDestinationCity(String country) {
        input(destinationInput, country);
        waitForElement(citiesDropdown);
        pressEnter(destinationInput);
        return this;
    }

    /**
     * Click departure date & open calendar - day picker
     *
     * @return
     */
    public TravelFilterPO openDepartureDateCalendar(){
        pressAndWaitForElement(departureDateInput, dayPicker);
        return this;
    }

    /**
     * Choose month in calendar - day picker
     * @return
     */
    public TravelFilterPO selectMonthCalendar(String month){
        while (!getText(calendarMonthText).equalsIgnoreCase(month)) {
            press(chooseMonthArrow);
        }
        return this;
    }

    /**
     * Choose day in calendar - day picker
     * @return
     */
    public TravelFilterPO selectDateDay(String date){
        press(Locators.flightDayDate.getWithParams(date));
    return this;
    }

    /**
     * Click Search Flight Button
     * @return
     */
    public TravelFilterPO clickSearchFlightButton() {
        press(searchFlightsButton);
        return this;
    }




}
