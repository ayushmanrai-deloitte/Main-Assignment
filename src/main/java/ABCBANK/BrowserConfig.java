package ABCBANK;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class BrowserConfig {
    public static WebDriver driver;
    public static void initialize() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
    }
}
