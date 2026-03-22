import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static Calculator calculator = new Calculator();

    @BeforeClass
    public void setUp() {
        System.out.println("setUp on thread: " + Thread.currentThread().getName());
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Test completed on thread: " + Thread.currentThread().getName());
    }
}