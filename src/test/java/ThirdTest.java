import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

//KUPNJA

public class ThirdTest {
     public WebDriver driver;

    public String testURL = "https://proton-vrecice.hr/naslovnica/46-vrecica-za-usisavac-kirby.html";

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(200));

        WebElement add =
                driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")
                );

        add.click();
        Thread.sleep(2000);

        WebElement finish =
                driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
                );

        finish.click();
        Thread.sleep(2000);

        WebElement done =
                driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div/a"));

        done.click();
        Thread.sleep(2000);

        WebElement testLink =
                driver.findElement(By.xpath("//*[@id=\"checkout-personal-information-step\"]/div/ul/li[1]/a")
                );

        Thread.sleep(1000);

        Assert.assertEquals(testLink.getText(), "Naručite kao gost uz obvezu plaćanja");
        System.out.print(testLink.getText());
    }

    @AfterMethod
    public void teardownTest() {

        driver.quit();
    }
}
