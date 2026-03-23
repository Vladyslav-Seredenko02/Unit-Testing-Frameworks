import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DoubleSqrtTest extends BaseTest {

    @DataProvider(name = "sqrtDoubleData")
    public Object[][] sqrtDoubleData() {
        return new Object[][]{
                {4.0D, 2.0D},
                {9.0D, 3.0D},
                {2.0, 1.4142D},
                {0.0D, 0.0D},
                {-4.0D, 2.0D}
        };
    }

    @Test(dataProvider = "sqrtDoubleData", groups = "regression")
    public void testSqrtDouble(double a, double expected) {
        Assert.assertEquals(calculator.sqrt(a), expected, 0.0001, "Sqrt for " + a
                + " is wrong");
    }
}