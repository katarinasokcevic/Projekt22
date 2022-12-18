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

public class FifthTest {
    public WebDriver driver;

    public String testURL = "https://hdbs.hr/";

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(50));

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/header/div[2]/div[2]/div/div/div/div[2]/div/div[2]/ul/li[4]/a")));

        Thread.sleep(2000);

        button.click();

        Thread.sleep(3000);

        WebElement testLink =
                driver.findElement(By.xpath("/html/body/div[3]/div[1]/section/div/div/div[2]/div/div/div/div[3]/div[1]/div[1]")
                );

        testLink.click();

        Thread.sleep(2000);

        WebElement testLink2 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/section/div/div/div[2]/div/div/div/div[3]/div[1]/div[2]/a/h3"));
        testLink2.click();

        Thread.sleep(3000);

        // We expect two tabs
        Assert.assertEquals(driver.getWindowHandles().size(), 2);
    }
    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
