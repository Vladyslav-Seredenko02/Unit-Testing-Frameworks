import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LongSubTest extends BaseTest{

    @DataProvider(name = "subLongData")
    public Object[][] subLongData() {
        return new Object[][] {
                {3L, 1L, 2L},
                {5L, 5L, 0L},
                {3L, 6L, -3L}
        };
    }

    @Test(dataProvider = "subLongData")
    public void testSubLong(long a, long b, long expected) {
        Assert.assertEquals(calculator.sub(a, b), expected, "Expected result for subtraction " + a
                + " and " + b + " is wrong");
    }
}