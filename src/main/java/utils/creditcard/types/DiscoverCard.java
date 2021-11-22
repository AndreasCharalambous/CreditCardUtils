package utils.creditcard.types;


public class DiscoverCard implements CreditCard {

    public DiscoverCard(final String cardNo) {
        // TODO Auto-generated constructor stub
    }

    public static DiscoverCard createCard(final String cardNo) {
        return new DiscoverCard(cardNo);
    }

}
