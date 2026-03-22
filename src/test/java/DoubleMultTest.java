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
                {0.0D, 3.0D, 0.0D}
        };
    }

    @Test(dataProvider = "multDoubleData", groups = "regression")
    public void testMultDouble(double a, double b, double expected) {
        Assert.assertEquals(calculator.mult(a, b), expected, 0.0001);
    }

    @Test(groups = "regression")
    public void testMultDoubleFloorsResult() {
        Assert.assertEquals(calculator.mult(2.5D, 2.5D), 6.0D, 0.0001);
        System.out.println("mult(a, b) returns Math.floor(a * b) instead of a * b\n" +
                "so 2.5 * 2.5 = 6.25 -> floor(6.25) = 6.0 ");
    }
}