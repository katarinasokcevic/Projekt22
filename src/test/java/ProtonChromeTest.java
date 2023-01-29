import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProtonChromeTest extends ProtonTest {
    @Override
    protected WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        return new ChromeDriver();
    }
}
