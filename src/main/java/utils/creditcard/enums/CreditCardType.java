package utils.creditcard.enums;

public enum CreditCardType {

    AMERICAN_EXPRESS("51–55", true, "16", "Luhn algorithm"),
    BANKCARD("51–55", true, "16", "Luhn algorithm"),
//    CHINA_T_UNION,
//    CHINA_UNIONPAY,
//    DINERS_CLUB_ENROUTE,
//    DINERS_CLUB_INTERNATIONAL,
//    DINERS_CLUB_UNITED_STATES_AND_CANADA,
//    DISCOVER_CARD,
//    UKRCARD,
//    RUPAY,
//    INTERPAYMENT,
//    INSTAPAYMENT,
//    JCB,
//    LASER,
//    MAESTRO_UK,
//    MAESTRO,
//    DANKORT,
//    MIR,
//    NPS_PRIDNESTROVIE,
//    MASTERCARD,
//    SOLO,
//    SWITCH,
//    TROY,
    VISA("4",true,"16","Luhn algorithm"),
//    VISA_ELECTRON,
//    UATP,
//    VERVE,
//    LANKAPAY,
//    UZCARD,
//    HUMO;
;
    private final String iinRange;
    private final boolean active;
    private final String size;
    private final String algorithm;

    CreditCardType(final String iinRange, final boolean active, final String size, final String algorithm) {
        this.iinRange = iinRange;
        this.active = active;
        this.size = size;
        this.algorithm = algorithm;
    }

    public String getIinRange() {
        return iinRange;
    }

    public boolean isActive() {
        return active;
    }

    public String getSize() {
        return size;
    }

    public String getAlgorithm() {
        return algorithm;
    }
}
