import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

//KORISTENJE FIREFOX , OPIS ARTIKLA

public class FifthTest {
    public WebDriver driver;

    public String testURL = "https://proton-vrecice.hr/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.navigate().to(testURL);
    }
    @Test
    public void googleSearchTest() throws InterruptedException {
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(80));

        WebElement button = driver.findElement(By.xpath("//*[@id=\"category-6\"]/a"));
        button.click();
        Thread.sleep(2000);

        WebElement samsung = driver.findElement(By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a"));
        samsung.click();
        Thread.sleep(2000);

        WebElement slika = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a/img"));
        slika.click();
        Thread.sleep(2000);

        WebElement details = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/div[2]/div[3]/ul/li[2]/a"));
        details.click();
        Thread.sleep(2000);

        WebElement text = driver.findElement(By.xpath("//*[@id=\"product-details\"]/div[1]"));
        Assert.assertEquals(text.getText(), "Referenca TIP 2");

    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
