package utils.creditcard.types;


public class MasterCard implements CreditCard {

	private final String cardNo;
	private final String bankNumber;
	private final String accountNumber;
	private final char checkDigit;

	private MasterCard(final String cardNo, final String bankNumber, final String accountNumber,
			final char checkDigit) {
		this.cardNo = cardNo;
		this.bankNumber = bankNumber;
		this.accountNumber = accountNumber;
		this.checkDigit = checkDigit;
	}

	/**
	 * Digits 2 & 3, 2-4, 2-5, or 2-6: Make up the bank number; depends on whether
	 * digit two is a 1, 2, 3 or other digit </br>
	 * Digits after the bank number, up to digit 15: Represent the account
	 * number</br>
	 * Digit 16: Is a check digit</br>
	 * 
	 * @param cardNo - card number on the card
	 * @return new immutable instance of MasterCard
	 */
	public static MasterCard createCard(final String cardNo) {

		final String bankNumber;
		final String accountNumber;

		char bankNoHelper = cardNo.charAt(1);

		if (bankNoHelper == '1') {
			bankNumber = cardNo.substring(1, 3);
			accountNumber = cardNo.substring(3, 15);

		} else if (bankNoHelper == '2') {
			bankNumber = cardNo.substring(1, 4);
			accountNumber = cardNo.substring(4, 15);

		} else if (bankNoHelper == '3') {
			bankNumber = cardNo.substring(1, 5);
			accountNumber = cardNo.substring(5, 15);

		} else {
			bankNumber = cardNo.substring(1, 6);
			accountNumber = cardNo.substring(6, 15);
		}

		final char checkDigit = cardNo.charAt(cardNo.length() - 1);

		return new MasterCard(cardNo, bankNumber, accountNumber, checkDigit);
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
