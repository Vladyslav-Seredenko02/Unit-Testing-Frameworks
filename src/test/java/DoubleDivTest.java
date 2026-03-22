import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DoubleDivTest extends BaseTest {

    @DataProvider(name = "divDoubleData")
    public Object[][] divDoubleData() {
        return new Object[][]{
                {10.0D, 2.0D, 5.0D},
                {-10.0D, 2.0D, -5.0D},
                {0.0D, 5.0D, 0.0D},
                {9.0D, 1.0D, 9.0D}
        };
    }

    @Test(dataProvider = "divDoubleData", groups = "regression")
    public void testDivDouble(double a, double b, double expected) {
        Assert.assertEquals(calculator.div(a, b), expected, 0.0001);
    }

    /*
    !!!
     */
    @Test(groups = "regression")
    public void testDivDoubleByZero() {
        Assert.assertTrue(Double.isInfinite(calculator.div(12.0D, 0.0D)));
        System.out.println("double division by zero returns Infinity,\n" +
                "unlike long division which throws NumberFormatException");
    }
}