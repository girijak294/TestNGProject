package test.calculator;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorTest {

    Calculator calculator;

    @BeforeClass
    public void setUpClass() {
        // Runs once before all tests
        System.out.println("Initializing Calculator Test Suite");
    }

    @BeforeMethod
    public void setUp() {
        // Runs before each test
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        // Runs after each test
        System.out.println("Test complete.");
    }

    @AfterClass
    public void tearDownClass() {
        // Runs once after all tests
        System.out.println("Test Suite Finished.");
    }

    @Test
    public void testAdditionPositive() {
        double result = calculator.sum(5.5, 3.5);
        Assert.assertEquals(result, 8, "Addition test failed");
    }

    @Test
    public void testSubtractionPositive() {
        double result = calculator.sub(10, 5);
        Assert.assertEquals(result, 5, "Subtraction test failed");
    }

    @Test
    public void testMultiplicationPositive() {
        long result = calculator.mult(4, 5);  // mult(long, long)
        Assert.assertEquals(result, 20, "Multiplication test failed");
    }
    
    @Test
    public void testSqrtPositive() {
        double result = calculator.sqrt(16);  // sqrt(double)
        Assert.assertEquals(result, 4.0, "Square root test failed");
    }

    // Negative Test Example: Testing division by zero
    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        calculator.div(10, 0);
    }
    
    @DataProvider(name = "multiplicationData")
    public Object[][] multiplicationData() {
        return new Object[][] {
            { 2, 3, 6 },
            { -2, -3, 6 },
            { 2, -3, -6 },
            { 0, 5, 0 },
            { Integer.MAX_VALUE, 1, Integer.MAX_VALUE }
        };
    }

    @Test(dataProvider = "multiplicationData", groups = "multiplication")
    public void testMultiply(int a, int b, int expected) {
        Assert.assertEquals(calculator.mult(a, b), expected);
    }
}
