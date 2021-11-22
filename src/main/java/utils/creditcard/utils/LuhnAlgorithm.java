package utils.creditcard.utils;

public class LuhnAlgorithm {


    /**
     * @see <a href="https://en.wikipedia.org/wiki/Luhn_algorithm">Luhn_algorithm</a>
     * @param cardNo  - value that needs validation
     * @return true if is valid
     */
    public static boolean validate(final String cardNo) {
        int sum = 0;
        boolean secondDigit = false;
        for (char c : cardNo.toCharArray()) {

            //convert char to int
            int currentNumber = c - '0';

            //every second number multiply by 2
            if (secondDigit) {
                currentNumber = currentNumber * 2;
            }
            sum += currentNumber / 10; //(add first part of a two digits number)
            sum += currentNumber % 10; //(add second part of a two digits number)

            secondDigit = !secondDigit;
        }
        return (sum % 10 == 0);
    }

}
