import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ProtonEdgeTest extends ProtonTest{
    @Override
    protected WebDriver createDriver() {
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
        return new EdgeDriver();
    }

}
