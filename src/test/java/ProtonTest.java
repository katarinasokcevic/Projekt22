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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ProtonTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String testBaseURL = "https://proton-vrecice.hr/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofMillis(300));
    }

    private void clickThrough(List<By> bys) {
        for (By by : bys) {
            wait.until(ExpectedConditions.elementToBeClickable(by)).click();
        }
    }

    @Test
    public void loginPretplataTest() throws InterruptedException {

        driver.navigate().to(testBaseURL);
        this.clickThrough(new ArrayList<By>() {{
            add(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a"));
        }});
        WebElement email_name =
                driver.findElement(By.id("field-email"));

        email_name.sendKeys("katarina.sokcevic.vk@gmail.com");

        WebElement lozinka =
                driver.findElement(By.id("field-password"));

        lozinka.sendKeys("lozinka123");

        WebElement prijava_button =
                driver.findElement(By.id("submit-login"));
        prijava_button.click();

        WebElement textbox =
                driver.findElement(By.xpath("//*[@id=\"blockEmailSubscription_displayFooterBefore\"]/div/div/form/div/div[1]/div[1]/input"));

        textbox.sendKeys("katarina.sokcevic.vk@gmail.com");

        WebElement pretplata =
                driver.findElement(By.xpath("//*[@id=\"blockEmailSubscription_displayFooterBefore\"]/div/div/form/div/div[1]/input[1]"));

        pretplata.click();

        WebElement text =
                driver.findElement(By.xpath("//*[@id=\"blockEmailSubscription_displayFooterBefore\"]/div/div/form/p"));


        Assert.assertEquals(text.getText(), "E-mail adresa je već registrirana");
        System.out.print(text.getText());
    }


    @Test
    public void kirbySearchTest() throws InterruptedException {
        driver.navigate().to(testBaseURL);

        WebElement searchbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_widget\"]/form/input[2]")));
        searchbox.sendKeys("kirby");
        searchbox.submit();

        this.clickThrough(new ArrayList<By>() {{
            add(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a/img"));
        }});

        WebElement testLink =
                driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/h1")
                );

        Assert.assertEquals(testLink.getText(), "TIP 40 KIRBY VREĆICA ZA USISAVAČ - 3 KOM");
        System.out.print(testLink.getText());
    }


    @Test
    public void checkoutTest() throws InterruptedException {
        driver.navigate().to(testBaseURL + "naslovnica/46-vrecica-za-usisavac-kirby.html");
        clickThrough(new ArrayList<By>() {{
            add(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"));
            add(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
            add(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div/a"));
        }});

        WebElement testLink =
                driver.findElement(By.xpath("//*[@id=\"checkout-personal-information-step\"]/div/ul/li[1]/a")
                );

        Assert.assertEquals(testLink.getText(), "Naručite kao gost uz obvezu plaćanja");
        System.out.print(testLink.getText());
    }


    @Test
    public void addAndRemoveFromCartTest() throws InterruptedException {
        driver.navigate().to(testBaseURL + "naslovnica/46-vrecica-za-usisavac-kirby.html");
        clickThrough(new ArrayList<By>() {{
            add(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[1]/div/span[3]/button[1]"));
            add(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"));
            add(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
        }});

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"cart-subtotal-products\"]/span[1]")).getText(), "2 artikala");
        WebElement remove =
                driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[3]/div/a/i"));

        remove.click();

        WebElement testLink =
                driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/span")
                );

        Assert.assertEquals(testLink.getText(), "Nemate više artikala u košarici");
        System.out.print(testLink.getText());
    }

    @Test
    public void detailOfProduct() throws InterruptedException {
        driver.navigate().to(testBaseURL);
        clickThrough(new ArrayList<By>() {{
            add(By.xpath("//*[@id=\"category-6\"]/a"));
            add(By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a"));
            add(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a/img"));
            add(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/div[2]/div[3]/ul/li[2]/a"));
        }});

        Thread.sleep(300);

        WebElement text = driver.findElement(By.xpath("//*[@id=\"product-details\"]/div[1]"));

        Assert.assertEquals(text.getText(), "Referenca TIP 2");
        System.out.print(text.getText());
    }

    @Test
    public void filterProducts() throws InterruptedException {
        driver.navigate().to(testBaseURL);

        WebElement searchbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_widget\"]/form/input[2]")));
        searchbox.sendKeys("vrećica");
        searchbox.submit();

        clickThrough(new ArrayList<By>() {{
            add(By.xpath("//*[@id=\"js-product-list-top\"]/div[2]/div/div/button"));
            add(By.xpath("//*[@id=\"js-product-list-top\"]/div[2]/div/div/div/a[5]"));
        }});

        Thread.sleep(300);

        WebElement text = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div[1]/article/div/div[2]/h2/a"));

        Assert.assertEquals(text.getText(), "TIP 33...");
        System.out.print(text.getText());

    }


    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }

}
