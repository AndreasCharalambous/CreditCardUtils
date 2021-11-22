package utils.creditcard.utils;

import java.util.function.Function;
import java.util.function.Predicate;

public class Validator {

    private final Function<String, Boolean> testIinRange;
    private final Predicate<Boolean> testIsActive;
    private final Function <String, Boolean> testSize;
    private final Function <String, Boolean> testAlgorithm;


    public Validator(Function<String, Boolean> testIinRange, Predicate<Boolean> testIsActive, Function<String, Boolean> testSize, Function<String, Boolean> testAlgorithm) {
        this.testIinRange = testIinRange;
        this.testIsActive = testIsActive;
        this.testSize = testSize;
        this.testAlgorithm = testAlgorithm;
    }


}
