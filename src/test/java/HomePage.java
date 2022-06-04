import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomePage {

    WebDriver driver;

    public void login(){
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
    }

    @BeforeMethod
    public void LaunchPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void TestLoginPageTitle(){
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test
    public void TestLogin(){
        login();
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("products"));
    }

    @Test
    public void TestViewProductDetails() throws InterruptedException {
        login();
        List<WebElement> productNames = driver.findElements(By.cssSelector(".inventory_item_name"));
        productNames.get(0).click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("back to products"));
    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

}
