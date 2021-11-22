package utils.creditcard.types;

import utils.creditcard.enums.CreditCardType;

public class Visa implements CreditCard {

    public static final CreditCardType TYPE = CreditCardType.VISA;

    private final String cardNo;

    private final String bankNumber;
    private final String accountNumber;
    private final char checkDigit;

    private Visa(final String cardNo, final String bankNumber, final String accountNumber, final char checkDigit) {
        this.cardNo = cardNo;
        this.bankNumber = bankNumber;
        this.accountNumber = accountNumber;
        this.checkDigit = checkDigit;
    }

    /**
     * Digits 2-6: Make up the bank number</br>
     * Digits 7-12 or 7-15: Represent the account number</br>
     * Digits 13 or 16: Is a check digit</br>
     * Example : 4012888888881881</br>
     *
     * @param cardNo - card number on the card
     * @return new immutable instance of VisaCard
     */
    public static Visa createCard(final String cardNo) {

        final String bankNumber = cardNo.substring(1, 6);

        final String accountNumber;
        if (cardNo.length() == 13) {
            accountNumber = cardNo.substring(6, 12);
        } else {
            accountNumber = cardNo.substring(6, 15);
        }

        final char checkDigit = cardNo.charAt(cardNo.length() - 1);

        return new Visa(cardNo, bankNumber, accountNumber, checkDigit);
    }

    public String getCardNo() {
        return cardNo;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public char getCheckDigit() {
        return checkDigit;
    }

}
