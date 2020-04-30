import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebdriverFactory {

    public WebDriver create(String browser, String options) {
        return create(browser);
    }

    public WebDriver create(String browser) {

        String browserName = browser == null ? "CHROME" : browser.toUpperCase();
        switch (Browsers.valueOf(browserName)) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                throw new IllegalStateException("browser name must be specified");
        }
    }
}
