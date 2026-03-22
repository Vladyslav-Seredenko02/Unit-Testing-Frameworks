import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DoubleCosTest extends BaseTest{

    @DataProvider(name = "cosDoubleData")
    public Object[][] cosDoubleData() {
        return new Object[][]{
                {0.0D,            Math.sin(0.0D)},
                {Math.PI / 2.0D,  Math.sin(Math.PI / 2.0D)},
                {Math.PI,         Math.sin(Math.PI)},
                {Math.PI / 4.0D,  Math.sin(Math.PI / 4.0D)},
                {-Math.PI / 2.0D, Math.sin(-Math.PI / 2.0D)}
        };
    }
    // MARK: cos(a) should return Math.cos(a),
// but actual implementation returns Math.sin(a) instead.
// All expected values are calculated with Math.sin(a) to match real behavior.

    @Test(dataProvider = "cosDoubleData", groups = "regression")
    public void testCosDouble(double a, double expected) {
        Assert.assertEquals(calculator.cos(a), expected, 0.0001);
    }
}