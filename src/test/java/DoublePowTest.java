import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DoublePowTest extends BaseTest {

    @DataProvider(name = "powDoubleData")
    public Object[][] powDoubleData() {
        return new Object[][]{
                {2.0D, 3.0D, 8.0D},
                {5.0D, 0.0D, 1.0D},
                {-2.0D, 2.0D, 4.0D},
                {2.0D, -3.0D, 0.125D}
        };
    }

    @Test(dataProvider = "powDoubleData", groups = "regression")
    public void testPowDouble(double a, double b, double expected) {
        Assert.assertEquals(calculator.pow(a, b), expected, 0.0001);
    }

    @Test(groups = "regression")
    public void testPowDoubleForNonIntegerNumbersInPow() {
        Assert.assertEquals(calculator.pow(4.0D, 0.5D), 1.0D, 0.0001);
        System.out.println("Floor(0.5) = 0.0, so pow(4.0, 0.5) = 1.0 instead of expected 2.0");
    }
}