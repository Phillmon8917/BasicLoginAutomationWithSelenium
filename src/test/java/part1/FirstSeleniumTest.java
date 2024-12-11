package part1;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSeleniumTest
{

    WebDriver driver;

    //The following should always run before the class runs
    @BeforeClass
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //This maximizes the window of the screen
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit(); //Mostly use this to close every window
        //alternatively close only closes the current window
    }

    @Test
    public void testLoggingIntoApplication() throws InterruptedException
    {
        Thread.sleep(2000);

        //populating the username
      WebElement username =  driver.findElement(By.name("username"));
      username.sendKeys("Admin");

      //populating the password
      var password = driver.findElement(By.name("password"));
      password.sendKeys("admin123");

      //clicking the login button
      driver.findElement(By.tagName("button")).click();

      String actualResult = driver.findElement(By.tagName("h6")).getText();
      String expectedResults = "Dashboard";
      Assert.assertEquals(actualResult, expectedResults);

    }
}
