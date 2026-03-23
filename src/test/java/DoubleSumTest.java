import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DoubleSumTest extends BaseTest {

    @DataProvider(name = "sumDoubleData")
    public Object[][] sumDoubleData() {
        return new Object[][]{
                {2.5D, 3.1D, 5.6D},
                {0.0D, 5.2D, 5.2D},
                {-2.1D, 2.1D, 0.0D},
                {-3.5D, -1.5D, -5.0D}
        };
    }

    @Test(dataProvider = "sumDoubleData", groups = "regression")
    public void testSumDouble(double a, double b, double expected) {
        Assert.assertEquals(calculator.sum(a, b), expected, 0.0001, "Expected result for addition " + a
                + " and " + b + " is wrong");
    }
}