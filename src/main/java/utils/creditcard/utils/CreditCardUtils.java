package utils.creditcard.utils;

import utils.creditcard.exceptions.InvalidCardException;
import utils.creditcard.types.*;

import java.util.Objects;

public class CreditCardUtils {

    /**
     * Visa cards  Begin with a 4 and have 13 or 16 digits</br>
     * Mastercard cards  Begin with a 5 and has 16 digits</br>
     * American Express cards  Begin with a 3, followed by a 4 or a 7 has 15
     * digits</br>
     * Discover cards  Begin with a 6 and have 16 digits</br>
     *
     * @param cardNumber - the number on the card
     * @return an instance of CreditCard with details for the card number
     * @throws InvalidCardException
     * @see <a href=
     * "https://www.creditcardinsider.com/learn/anatomy-of-a-credit-card" />
     * Anatomy of a Credit Card </a>
     */
    public static CreditCard identify(final String cardNumber) throws InvalidCardException {

        Objects.requireNonNull(cardNumber);

        int count = 0;
        for (char c : cardNumber.toCharArray()) {
            count++;
            if (!Character.isDigit(c)) {
                throw new InvalidCardException("Card number can contain only digits , see position: " + count);
            }

        }

        // Visa Check
        if (cardNumber.startsWith("4") && (cardNumber.length() == 13 || cardNumber.length() == 16)) {
            return Visa.createCard(cardNumber);
        }
        // MasterCard Check
        if (cardNumber.startsWith("5") && cardNumber.length() == 16) {
            return MasterCard.createCard(cardNumber);
        }

        // American Express Check
        if ((cardNumber.startsWith("34") || cardNumber.startsWith("37")) && cardNumber.length() == 15) {
            return AmericanExpress.createCard(cardNumber);
        }

        // Discover card
        if (cardNumber.startsWith("6") && cardNumber.length() == 16) {
            return new DiscoverCard(cardNumber);
        }

        throw new InvalidCardException("Invalid card number, type not found");

    }


}
