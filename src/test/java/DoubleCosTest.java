import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DoubleCosTest extends BaseTest {

    @DataProvider(name = "cosDoubleData")
    public Object[][] cosDoubleData() {
        return new Object[][]{
                {0.0D, 1},
                {Math.PI / 2.0D, 0},
                {Math.PI, -1},
                {Math.PI / 4.0D, Math.sqrt(2) / 2},
                {-Math.PI / 2.0D, 0}
        };
    }

    // MARK: cos(a) should return Math.cos(a),
// but actual implementation returns Math.sin(a) instead.
// That's why this test fails.
    @Test(dataProvider = "cosDoubleData", groups = "regression")
    public void testCosDouble(double a, double expected) {
        Assert.assertEquals(calculator.cos(a), expected, 0.0001, "Cos for " + Math.ceil(Math.toDegrees(a))
                + "° is wrong");
    }
}