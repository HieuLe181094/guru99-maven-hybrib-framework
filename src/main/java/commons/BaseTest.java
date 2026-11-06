package commons;

import browserFactory.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Locale;
import java.util.Random;

public class BaseTest {
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;


    protected int generateFakeNumber(){
        Random random = new Random();
        return random.nextInt(9999);
    }

    protected WebDriver getBrowserDriver(String url, String browserName) {
        BrowserType browserType = BrowserType.valueOf(browserName.toUpperCase());
        switch (browserType) {
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference(
                        "signon.rememberSignons", false
                );
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        driver.get(GlobalContaints.DEV_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;
    }

    // Quite browser
    protected void closeBrowser(){
        if (driver == null) return;
        String driverInstanceName = driver.toString().toLowerCase();
        log.info("Driver instance name = " + driverInstanceName);
        try {
            driver.manage().deleteAllCookies();
        } finally {
            driver.quit();
            driver = null;
        }
    }


}
