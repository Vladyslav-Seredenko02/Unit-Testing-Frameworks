import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BooleanIsPositiveTest extends BaseTest{

    @DataProvider(name = "isPositiveData")
    public Object[][] isPositiveData() {
        return new Object[][]{
                {1L, true},
                {0L, false},
                {1314L, true},
                {-12324L, false}
        };
    }

    @Test(dataProvider = "isPositiveData", groups = "smoke")
    public void testIsPositive(long value, boolean expected) {
        Assert.assertEquals(calculator.isPositive(value), expected);
    }
}