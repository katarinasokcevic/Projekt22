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

//DODAVANJE 2 ARTIKLA I BRISANJE ARTIKLA IZ KOSARICE

public class ForthTest {

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(50));

        WebElement more =
                driver.findElement(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[1]/div/span[3]/button[1]"));

        more.click();

        Thread.sleep(2000);

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

        WebElement remove =
                driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[3]/div/a/i"));

        remove.click();
        Thread.sleep(2000);

        WebElement testLink =
                driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/span")
                );

        Thread.sleep(1000);

        Assert.assertEquals(testLink.getText(), "Nemate više artikala u košarici");
        System.out.print(testLink.getText());
    }


    @AfterMethod
    public void teardownTest() {

        driver.quit();
    }
}
