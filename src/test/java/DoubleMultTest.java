import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DoubleMultTest extends BaseTest {

    @DataProvider(name = "multDoubleData")
    public Object[][] multDoubleData() {
        return new Object[][]{
                {10.0D, 10.0D, 100.0D},
                {5.0D, 6.0D, 30.0D},
                {-7.0D, 8.0D, -56.0D},
                {0.0D, 3.0D, 0.0D},
                {2.5D, 2.5D, 6.25D}
        };
    }

    // Method calculator.mult() contains rounding down,
    // So I believe that the mult() method should work with both integers and non-integers.
    // And if it only works with integers, then the method name should be something like "multWithRounding()".
    // But since it is called mult(), I consider rounding as a bug, so the last test will fail
    @Test(dataProvider = "multDoubleData", groups = "regression")
    public void testMultDouble(double a, double b, double expected) {
        Assert.assertEquals(calculator.mult(a, b), expected, 0.0001, "Expected result for multiplying " + a
                + " and " + b + " is wrong");
    }
}