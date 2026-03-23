import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DoubleTgTest extends BaseTest {

    @DataProvider(name = "tgDoubleData")
    public Object[][] tgDoubleData() {
        return new Object[][]{
                {Math.PI / 6.0D, 0.5773D},
                {Math.PI / 4.0D, 1.0D},
                {-Math.PI / 4.0D, -1.0D},
                {Math.PI / 3.0D, 1.7320D}
        };
    }

    //    MARK: tg(a) is implemented as sin(a) / cos(a),
//    but cos(a) incorrectly returns Math.sin(a) instead.
//    And that`s why tests fails
    @Test(dataProvider = "tgDoubleData", groups = "regression")
    public void testTgDouble(double a, double expected) {
        Assert.assertEquals(calculator.tg(a), expected, 0.0001, "Tg for " + Math.ceil(Math.toDegrees(a))
                + "° is wrong");
    }
}