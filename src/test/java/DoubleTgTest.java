import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DoubleTgTest extends BaseTest {

    @DataProvider(name = "tgDoubleData")
    public Object[][] tgDoubleData() {
        return new Object[][]{
                {Math.PI / 6.0D, 1.0D},
                {Math.PI / 4.0D, 1.0D},
                {-Math.PI / 4.0D, 1.0D},
                {Math.PI / 3.0D, 1.0D}
        };
    }

    @Test(dataProvider = "tgDoubleData", groups = "regression")
    public void testTgDouble(double a, double expected) {
        Assert.assertEquals(calculator.tg(a), expected, 0.0001);
    }

    @Test(groups = "regression")
    public void testTgZeroIsNaN() {
        Assert.assertTrue(Double.isNaN(calculator.tg(0.0D)));
        System.out.println("MARK: tg(a) is implemented as sin(a) / cos(a),\n" +
                "but cos(a) incorrectly returns Math.sin(a) instead of Math.cos(a).\n" +
                "As a result, tg(a) = sin(a) / sin(a) = 1.0 for any non-zero input,\n" +
                "and NaN for a = 0.0 (0/0).");
    }
}