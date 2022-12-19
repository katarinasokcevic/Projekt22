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

//PRETRAŽIVANJE

public class SecondTest {
    public WebDriver driver;
    public String testURL = "https://proton-vrecice.hr/";



    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);


        driver.navigate().to(testURL);
    }
    @Test
    public void googleSearchTest() throws InterruptedException {
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(300));

        WebElement searchbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_widget\"]/form/input[2]")));
        searchbox.sendKeys("kirby");
        searchbox.submit();

        Thread.sleep(2000);

        WebElement photo =
                driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a/img")
                );

        photo.click();

        Thread.sleep(2000);

        WebElement testLink =
                driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/h1")
                );

        Thread.sleep(2000);

        Assert.assertEquals(testLink.getText(), "TIP 40 KIRBY VREĆICA ZA USISAVAČ - 3 KOM");
        System.out.print(testLink.getText());
    }

    @AfterMethod
    public void teardownTest() {

        driver.quit();
    }
}
