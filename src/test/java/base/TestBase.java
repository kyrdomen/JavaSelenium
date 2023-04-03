package base;

import common.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    /**
     * Before class set up method
     * Executed before each test
     *
     * @param hostUrl set at testng.xml test parameter
     */
    @Parameters({"hostUrl", "timeout"})
    @BeforeClass
    public void setUp(String hostUrl, int timeout) {
        // Overcome issue: https://www.selenium.dev/blog/2022/using-java11-httpclient/
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        // Set chrome as default driver
        String browser = System.getProperty("browser", "chrome");

        // Select webdriver by browser system property
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        // open browser, maximize window & set implicit wait
        driver.get(hostUrl);
        driver.manage().window().maximize();
        DriverFactory.setWebDriver(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    /**
     * After class tear down method
     * Executed after each test
     */
    @AfterClass
    public void tearDown() {
        DriverFactory.getWebDriver().quit();
    }
}
