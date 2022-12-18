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

public class SecondTest {
     public WebDriver driver;

    public String testURL = "https://www.dodgeballeurope.org/";

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(200));

        WebElement link =
                driver.findElement(By.xpath("//*[@id=\"menu-item-1070\"]/a/span[2]")
                );

        link.click();
        Thread.sleep(2000);

        WebElement photo =
                driver.findElement(By.xpath("//*[@id=\"av-masonry-1-item-1078\"]/figure/figcaption/div/div/h3")
                );

        photo.click();

        Thread.sleep(2000);

        WebElement testLink =
                driver.findElement(By.xpath("//*[@id=\"av_section_2\"]/div/div/div/div/div[1]/div/h3")
                );

        Thread.sleep(1000);

        Assert.assertEquals(testLink.getText(), "Informations");
        System.out.print(testLink.getText());
    }

    @AfterMethod
    public void teardownTest() {

        driver.quit();
    }
}
