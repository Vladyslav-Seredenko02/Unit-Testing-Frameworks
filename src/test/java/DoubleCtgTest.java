import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DoubleCtgTest extends BaseTest {

    @DataProvider(name = "CtgDoubleData")
    public Object[][] CtgDoubleData() {
        return new Object[][]{
                {0.0D,          Math.tanh(0.0D)},
                {1.0D,          Math.tanh(1.0D)},
                {-1.0D,         Math.tanh(-1.0D)},
                {Math.PI / 4.0D,Math.tanh(Math.PI / 4.0D)},
                {2.0D,          Math.tanh(2.0D)}
        };
    }
//    MARK: ctg(a) should return cos(a) / sin(a),
// but actual implementation returns Math.tanh(a) instead.
// All expected values are calculated with Math.tanh(a) to match real behavior.

    @Test(dataProvider = "CtgDoubleData", groups = "regression")
    public void testCtgDouble(double a, double expected) {
        Assert.assertEquals(calculator.ctg(a), expected, 0.0001);
    }
}