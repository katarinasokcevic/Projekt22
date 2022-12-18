import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    public WebDriver driver;

    public String testURL = "https://hotdogcat.com/";
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kety\\Downloads\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);


        driver.navigate().to(testURL);
    }
    @Test
    public void googleSearchTest() throws InterruptedException {
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100));


        WebElement text =
                driver.findElement(By.xpath("/html/body/p[2]")
                );

        Thread.sleep(3000);

        Assert.assertEquals(text.getText(), "HOT DOG CAT - FOR ALL YOUR HOT DOG CAT NEEDS.");
        System.out.print(text.getText());
    }
    @AfterMethod
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}
