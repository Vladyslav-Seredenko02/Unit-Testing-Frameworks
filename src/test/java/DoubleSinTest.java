import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DoubleSinTest extends BaseTest{

    @DataProvider(name = "sinDoubleData")
    public Object[][] sinDoubleData() {
        return new Object[][]{
                {0.0D,               0.0D},
                {Math.PI / 2.0D,     1.0D},
                {Math.PI,            0.0D},
                {-Math.PI / 2.0D,   -1.0D},
                {Math.PI / 6.0D,     0.5D}
        };
    }

    @Test(dataProvider = "sinDoubleData", groups = "regression")
    public void testSinDouble(double a, double expected) {
        Assert.assertEquals(calculator.sin(a), expected, 0.0001, "Sin for " + Math.ceil(Math.toDegrees(a))
                + "° is wrong");
    }
}