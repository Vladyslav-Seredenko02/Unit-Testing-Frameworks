import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LongMultTest extends BaseTest {

    @DataProvider(name = "multLongData")
    public Object[][] multLongData() {
        return new Object[][]{
                {10L, 10L, 100L},
                {5L, 6L, 30L},
                {-7L, 8L, -56L},
                {0L, 3L, 0L}
        };
    }

    @Test(dataProvider = "multLongData", groups = "smoke")
    public void testmultLong(long a, long b, long expected) {
        Assert.assertEquals(calculator.mult(a, b), expected, "Expected result for multiplying " + a
                + " and " + b + " is wrong");
    }
}