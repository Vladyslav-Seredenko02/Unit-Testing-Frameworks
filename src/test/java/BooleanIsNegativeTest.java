import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BooleanIsNegativeTest extends BaseTest{

    @DataProvider(name = "isNegativeData")
    public Object[][] isNegativeData() {
        return new Object[][]{
                {-1L, true},
                {0L, false},
                {1314L, false},
                {-12324L, true}
        };
    }

    @Test(dataProvider = "isNegativeData", groups = "smoke")
    public void testIsNegative(long value, boolean expected) {
        Assert.assertEquals(calculator.isNegative(value), expected, "Value " + value + " isn`t negative");
    }
}