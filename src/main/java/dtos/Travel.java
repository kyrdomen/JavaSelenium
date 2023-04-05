package dtos;

import enums.Cities;
import enums.DateFormatTypes;
import enums.SeatClass;
import enums.TravelKind;
import lombok.Builder;
import lombok.Data;

import static time.DateTimeProvider.getDatePlusToday;

@Data
@Builder
public class Travel {
    @Builder.Default
    public TravelKind typeOfTravel = TravelKind.Return;
    @Builder.Default
    public String fromCity = Cities.Athens.name();
    @Builder.Default
    public String toCity = Cities.Helsinki.name();
    public String multiFromCity ;
    public String multiToCity ;
    @Builder.Default
    public Integer passengers = 1;
    @Builder.Default
    public SeatClass passengerClass = SeatClass.Economy;

    @Builder.Default
    public String fromDate = getDatePlusToday(10, DateFormatTypes.FULL_FORMAT.get());
    @Builder.Default
    public String toDate =  getDatePlusToday(17, DateFormatTypes.FULL_FORMAT.get());
    @Builder.Default
    public String toMonth = getDatePlusToday(10, DateFormatTypes.MONTH_FORMAT.get());
    @Builder.Default
    public String fromMonth = getDatePlusToday(17, DateFormatTypes.MONTH_FORMAT.get());

    public String multiFromDate;
    public String multiFromMonth;
}
