package utils.creditcard.types;

public class AmericanExpress implements CreditCard {

    private final String cardNo;
    private final char type;
    private final char currency;
    private final String accountNumber;
    private final String cardAccNumber;
    private final char checkDigit;

    public AmericanExpress(final String cardNo, final char type, final char currency, final String accountNumber,
                           final String cardAccNumber, final char checkDigit) {
        this.cardNo = cardNo;
        this.type = type;
        this.currency = currency;
        this.accountNumber = accountNumber;
        this.cardAccNumber = cardAccNumber;
        this.checkDigit = checkDigit;
    }

    /**
     * Digits 3 & 4: Are type and currency</br>
     * Digits 5-11: Represent the account number</br>
     * Digits 12-14: Represent the card number within the account</br>
     * Digit 15: Is a check digit</br>
     *
     * @param cardNo - card number on the card
     * @return new immutable instance of AmericanExpressCard
     */
    public static AmericanExpress createCard(final String cardNo) {

        final char type = cardNo.charAt(2);
        final char currency = cardNo.charAt(3);
        final String accountNumber = cardNo.substring(4, 11);
        final String cardAccNumber = cardNo.substring(11, 14);
        final char checkDigit = cardNo.charAt(cardNo.length() - 1);

        return new AmericanExpress(cardNo, type, currency, accountNumber, cardAccNumber, checkDigit);
    }

    public String getCardNo() {
        return cardNo;
    }

    public char getType() {
        return type;
    }

    public char getCurrency() {
        return currency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCardAccNumber() {
        return cardAccNumber;
    }

    public char getCheckDigit() {
        return checkDigit;
    }

}
