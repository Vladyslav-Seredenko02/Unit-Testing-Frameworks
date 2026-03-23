import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DoubleCtgTest extends BaseTest {

    @DataProvider(name = "CtgDoubleData")
    public Object[][] CtgDoubleData() {
        return new Object[][]{
                {Math.PI / 2.0D, 0.0D},
                {Math.PI / 6.0D, 1.7320D},
                {Math.PI / 4.0D, 1.0D},
                {-Math.PI / 4.0D, -1.0D},
                {Math.PI / 3.0D, 0.5773D}
        };
    }
//    MARK: ctg(a) should return cos(a) / sin(a),
// but actual implementation returns Math.tanh(a) instead.
// And that`s why tests fails

    @Test(dataProvider = "CtgDoubleData", groups = "regression")
    public void testCtgDouble(double a, double expected) {
        Assert.assertEquals(calculator.ctg(a), expected, 0.0001, "Ctg for " + Math.ceil(Math.toDegrees(a))
                + "° is wrong");
    }

    @Test(groups = "regression")
    public void testCtgDoubleForZero() {
        double expected = calculator.ctg(0.0D);
        Assert.assertTrue(Double.isInfinite(expected), "Expected result isn`t infinite: " + expected);
    }
}