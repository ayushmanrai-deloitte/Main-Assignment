package ABCBANK;
import ABCBANK.BrowserConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;
public class Login extends BrowserConfig {

    public Login(){
        PageFactory.initElements(driver,this);
    }
    public void ClickManagerLogin() {
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//button[contains(text(),'Bank Manager Login')]")).click();
    }

    public void ClickCustomerlogin() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[contains(text(),'Customer Login')]")).click();
    }

    public void ClickHome(){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@class='btn home']")).click();
    }
}

