package enums;

public enum Airlines {
    Volotea("Volotea"),
    Aegean_Airlines("Aegean Airlines"),
    KLM("KLM"),
    Ryanair("Ryanair"),
    Wizz_Air("Wizz Air");


    private String myOption;

    Airlines(String option) {
        myOption = option;
    }

    public String get() {
        return myOption;
    }

}
