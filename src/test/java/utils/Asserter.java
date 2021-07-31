package utils;


import org.junit.Assert;

import java.math.BigDecimal;

public class Asserter {

    public static void assertAmount(BigDecimal actualAmount, BigDecimal expectedAmount) {
        Assert.assertEquals(actualAmount, expectedAmount);
    }

    public static void assertIfAmountIsGreater(BigDecimal actualAmount, BigDecimal compareAmount) {
        Assert.assertEquals(actualAmount.compareTo(compareAmount), 1);
    }
}
