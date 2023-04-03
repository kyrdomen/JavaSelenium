package enums;

public enum DateFormatTypes {
    FULL_FORMAT("EEE MMM d yyyy"),
    MONTH_FORMAT("MMM yyyy"),
;

    private String myOption;

    DateFormatTypes(String option) {
        myOption = option;
    }

    public String get() {
        return myOption;
    }
}
