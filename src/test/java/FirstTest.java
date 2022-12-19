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


// LOGIRANJE I PRETPLATA NA EMAIL
public class FirstTest {

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

        WebElement prijava =
                driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a")
                );
        prijava.click();
        Thread.sleep(2000);

        WebElement email_name =
                driver.findElement(By.id("field-email"));

        email_name.sendKeys("katarina.sokcevic.vk@gmail.com");


        WebElement lozinka =
                driver.findElement(By .id("field-password"));

        lozinka.sendKeys("lozinka123");
        Thread.sleep(500);

        WebElement prijava_button =
                driver.findElement(By.id("submit-login"));
        prijava_button.click();

        Thread.sleep(2000);

        WebElement textbox =
                driver.findElement(By.xpath("//*[@id=\"blockEmailSubscription_displayFooterBefore\"]/div/div/form/div/div[1]/div[1]/input"));

        textbox.sendKeys("katarina.sokcevic.vk@gmail.com");

        Thread.sleep(2000);

        WebElement pretplata =
                driver.findElement(By.xpath("//*[@id=\"blockEmailSubscription_displayFooterBefore\"]/div/div/form/div/div[1]/input[1]"));

        pretplata.click();

        Thread.sleep(2000);

        WebElement text =
                driver.findElement(By.xpath("//*[@id=\"blockEmailSubscription_displayFooterBefore\"]/div/div/form/p"));

        Assert.assertEquals(text.getText(), "E-mail adresa je već registrirana");
        System.out.print(text.getText());
    }
    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }


}
