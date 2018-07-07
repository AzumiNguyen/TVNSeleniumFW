package modules;

import org.testng.annotations.*;

import static supports.CommonFunctions.launchBrowser;

public class ParallelSuiteTest {
    String testName = "";

    @BeforeTest
    @Parameters({"browser"})
    public void beforeTest(String testName) {
        this.testName = testName;
        launchBrowser(testName);
        long id = Thread.currentThread().getId();
        System.out.println("Before test " + testName + ". Thread id is: " + id);
    }

    @BeforeClass
    public void beforeClass() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-class " + testName + ". Thread id is: " + id);
    }

    @Test
    public void testMethodOne() {
        long id = Thread.currentThread().getId();
        System.out.println("Sample test-method " + testName + ". Thread id is: " + id);
    }

    @AfterClass
    public void afterClass() {
        long id = Thread.currentThread().getId();
        System.out.println("After test-method  " + testName + ". Thread id is: " + id);
    }

    @AfterTest
    public void afterTest() {
        long id = Thread.currentThread().getId();
        System.out.println("After test  " + testName + ". Thread id is: " + id);
    }

}
