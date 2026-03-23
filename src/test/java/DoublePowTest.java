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
                {2.0D, -3.0D, 0.125D},
                {2.0D, 0.5D, 1.4142D}
        };
    }

    // Method calculator.pow() contains rounding down,
    // So I believe that the pow() method should work with both integers and non-integers.
    // And if it only works with integers, then the method name should be something like "powWithRounding()".
    // But since it is called pow(), I consider rounding as a bug, so the last test will fail
    @Test(dataProvider = "powDoubleData", groups = "regression")
    public void testPowDouble(double a, double b, double expected) {
        Assert.assertEquals(calculator.pow(a, b), expected, 0.0001, "Expected result for exponentiation "
            + a + "^" + b + " is wrong");
    }
}