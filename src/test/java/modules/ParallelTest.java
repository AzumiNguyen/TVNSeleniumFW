package modules;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hado on 3/18/17.
 */
public class ParallelTest {
    @BeforeMethod
    public void beforeMethod() {
        long id = Thread.currentThread().getId();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Before test-method. Thread id is: " + id+" time at: "+dateFormat.format(date));
    }

    @Test
    public void testMethodsOne() throws InterruptedException {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method One. Thread id is: " + id);
        Thread.sleep(5000);
    }

    @Test
    public void testMethodsTwo() throws InterruptedException {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Two. Thread id is: " + id);
        Thread.sleep(5000);
    }
    @Test
    public void testMethodsThree() throws InterruptedException {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Three. Thread id is: " + id);
        Thread.sleep(5000);
    }
    @Test
    public void testMethodsFour() throws InterruptedException {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Four. Thread id is: " + id);
        Thread.sleep(5000);
    }
    @AfterMethod
    public void afterMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("After test-method. Thread id is: " + id);
    }
}
