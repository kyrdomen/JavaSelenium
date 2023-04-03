package enums;

public enum TravelKind {
    Return("Return"),
    Oneway("One-way"),
    Multicity("Multi-city"),
    Inbound("Inbound"),
    Outbound("Outbound");

    private String myOption;

    TravelKind(String option) {
        myOption = option;
    }

    public String get() {
        return myOption;
    }
}
