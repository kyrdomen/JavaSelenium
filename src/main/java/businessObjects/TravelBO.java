package businessObjects;

import dtos.Travel;
import enums.TravelKind;
import pageObjects.HomePagePO;
import pageObjects.TravelFilterPO;
import validator.Validator;

public class TravelBO extends Validator {

    protected HomePagePO homePagePO = new HomePagePO();
    protected TravelFilterPO travelFilterPO = new TravelFilterPO();


    /**
     * Search for travel
     *
     * @param travel
     */
    public TravelBO searchForTravel(Travel travel) {
        homePagePO.clickAcceptTermsButton();
        switch (travel.typeOfTravel) {
            case Return:
                searchForNewTravelReturn(travel);
                break;
            case Oneway:
                searchForNewTravelOneWay(travel);
                break;
            case Multicity:
                searchForNewTravelMulti(travel);
                break;
            default:
        }
        return this;
    }

    /**
     * Filter Travel with Return
     *
     * @param travel
     */
    public TravelBO searchForNewTravelReturn(Travel travel) {
        travelFilterPO.inputOriginCity(travel.fromCity);
        travelFilterPO.inputDestinationCity(travel.toCity);
        travelFilterPO.selectMonthCalendar(travel.fromMonth, TravelKind.Departure);
        travelFilterPO.selectDateDay(travel.fromDate);
        travelFilterPO.selectMonthCalendar(travel.toMonth, TravelKind.Return);
        travelFilterPO.selectDateDay(travel.toDate);
        travelFilterPO.clickSearchFlightButton();
        return this;
    }

    /**
     * Filter Travel with One Way
     *
     * @param travel
     */
    public TravelBO searchForNewTravelOneWay(Travel travel) {
        travelFilterPO.inputOriginCity(travel.fromCity);
        travelFilterPO.inputDestinationCity(travel.toCity);
        travelFilterPO.selectMonthCalendar(travel.fromMonth, TravelKind.Departure);
        travelFilterPO.selectDateDay(travel.fromDate);
        travelFilterPO.clickSearchFlightButton();
        return this;
    }

    /**
     * Filter Travel with Multi Cities
     *
     * @param travel
     */
    public TravelBO searchForNewTravelMulti(Travel travel) {
        travelFilterPO.inputOriginCity(travel.fromCity);
        travelFilterPO.inputDestinationCity(travel.toCity);
        travelFilterPO.selectMonthCalendar(travel.fromMonth, TravelKind.Departure);
        travelFilterPO.selectDateDay(travel.fromDate);
        travelFilterPO.inputOriginCity(travel.multiFromCity);
        travelFilterPO.inputDestinationCity(travel.multiToCity);
        travelFilterPO.selectMonthCalendar(travel.multiFromMonth, TravelKind.Departure);
        travelFilterPO.selectDateDay(travel.multiFromDate);
        travelFilterPO.clickSearchFlightButton();
        return this;
    }
}
