import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ProtonFirefoxTest extends ProtonTest {
    @Override
    protected WebDriver createDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        return new FirefoxDriver();
    }
}

