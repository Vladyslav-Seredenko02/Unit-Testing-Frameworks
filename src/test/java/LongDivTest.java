import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LongDivTest extends BaseTest {

    @DataProvider(name = "divLongData")
    public Object[][] divLongData() {
        return new Object[][]{
                {10L, 2L, 5L},
                {-10L, 2L, -5L},
                {0L, 5L, 0L},
                {9L, 1L, 9L}
        };
    }

    @Test(dataProvider = "divLongData", groups = "smoke")
    public void testDivLong(long a, long b, long expected) {
        Assert.assertEquals(calculator.div(a, b), expected);
    }

    //This can also be done using annotation "expectedExceptions = NumberFormatException.class"
    //But I decided to implement this using Assert.expectThrows() for having custom message in the logs
    @Test(groups = "smoke")
    public void testDivLongByZero() {
        Assert.expectThrows(
                "NumberFormatException wasn`t thrown", NumberFormatException.class,
                () -> calculator.div(30L, 0L)
        );
    }
}