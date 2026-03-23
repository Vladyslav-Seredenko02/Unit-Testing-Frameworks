import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DoubleSubTest extends BaseTest {

    @DataProvider(name = "subDoubleData")
    public Object[][] subDoubleData() {
        return new Object[][]{
                {3.0D, 1.0D, 2.0D},
                {5.0D, 5.0D, 0.0D},
                {3.0D, 6.0D, -3.0D}
        };
    }

    @Test(dataProvider = "subDoubleData", groups = "smoke")
    public void testSubDouble(double a, double b, double expected) {
        Assert.assertEquals(calculator.sub(a, b), expected, 0.0001, "Expected result for subtraction " + a
                + " and " + b + " is wrong" );
    }
}