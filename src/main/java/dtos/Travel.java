package dtos;

import enums.Cities;
import enums.DateFormatTypes;
import enums.SeatClass;
import enums.TravelKind;

import static time.DateTimeProvider.getDatePlusToday;

public class Travel {
    public TravelKind typeOfTravel = TravelKind.Return;
    public String fromCity = Cities.Athens.name();
    public String toCity = Cities.Helsinki.name();
    public String multiFromCity ;
    public String multiToCity ;
    public Integer passengers = 1;
    public SeatClass passengerClass = SeatClass.Economy;

    public String fromDate = getDatePlusToday(10, DateFormatTypes.FULL_FORMAT.get());
    public String toDate =  getDatePlusToday(17, DateFormatTypes.FULL_FORMAT.get());
    public String toMonth = getDatePlusToday(10, DateFormatTypes.MONTH_FORMAT.get());;
    public String fromMonth = getDatePlusToday(17, DateFormatTypes.MONTH_FORMAT.get());

    public String multiFromDate;
    public String multiFromMonth;
}
