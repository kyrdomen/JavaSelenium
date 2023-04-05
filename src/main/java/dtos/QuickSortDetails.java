package dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuickSortDetails {
    public Integer Recommended;
    public Integer Promotion ;
    public Integer Cheapest;
    public Integer Shortest ;
}
