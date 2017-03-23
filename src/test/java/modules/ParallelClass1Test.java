package modules;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by hado on 3/18/17.
 */
public class ParallelClass1Test {
    public void beforeClass() {
        long id = Thread.currentThread().getId();
        System.out.println("Class1: Before test-class. Thread id is: " + id);
    }

    @Test
    public void testMethodOne() {
        long id = Thread.currentThread().getId();
        System.out.println("Class1: Sample test-method One. Thread id is: " + id);
    }

    @Test
    public void testMethodTwo() {
        long id = Thread.currentThread().getId();
        System.out.println("Class1: Sample test-method Two. Thread id is: " + id);
    }

    @AfterClass
    public void afterClass() {
        long id = Thread.currentThread().getId();
        System.out.println("Class1: After test-class. Thread id is: " + id);
    }
}
