package dtos;

import enums.Airlines;
import enums.NumberOfStops;
import enums.TravelKind;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Filters {
    @Builder.Default
    public NumberOfStops stops = NumberOfStops.OneStop;
    @Builder.Default
    public String airline = Airlines.KLM.get();
    @Builder.Default
    public int priceMin = 0;
    @Builder.Default
    public int priceMax = -200;
    @Builder.Default
    public int travelTimeMax = -200;
    @Builder.Default
    public int fromMin = 100;
    @Builder.Default
    public int fromMax= -100;
    @Builder.Default
    public int toMin = 100;
    @Builder.Default
    public int toMax= -100;
    @Builder.Default
    public TravelKind fromTimeLimit = TravelKind.Departure;
    @Builder.Default
    public TravelKind toTimeLimit = TravelKind.Arrival;

}
