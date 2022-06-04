import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicTestCases {

    @BeforeMethod
    public void login(){
        System.out.println("Login");
    }

    @AfterMethod
    public void logout(){
        System.out.println("Logout");
    }

    @Test(priority = 1)
    public void TestOne() {
        System.out.println("Test 1");
    }

    @Test(priority = 2)
    public void TestTwo() {
        System.out.println("Test 2");
    }

    @Test(priority = 3)
    public void TestThree() {
        System.out.println("Test 3");
    }

}