import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LongSumTest extends BaseTest {

    @DataProvider(name = "sumLongData")
    public Object[][] sumData() {
        return new Object[][]{
                {1L, 2L, 3L},
                {0L, 5L, 5L},
                {-2L, 4L, 2L}
        };
    }

    @Test(dataProvider = "sumLongData", groups = {"smoke"})
    public void testSumLong(long a, long b, long expected) {
        Assert.assertEquals(calculator.sum(a, b), expected, "Expected result for addition " + a
                + " and " + b + " is wrong");
    }
}