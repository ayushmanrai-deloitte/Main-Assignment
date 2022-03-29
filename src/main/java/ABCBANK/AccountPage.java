package  ABCBANK ;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.Random;
public class AccountPage extends BrowserConfig {
    Random random=new Random();
    public AccountPage(){
        PageFactory.initElements(driver,this);
    }
    public void Deposit(){
        driver.findElement(By.xpath("//button[@ng-click='deposit()']")).click();
        int randomNumber=(random.nextInt(65536)-32768)%10000;
        //Integer.toString(randomNumber);
        driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys(Integer.toString(randomNumber));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    public void Withdraw(){
        driver.findElement(By.xpath("//button[@ng-click='withdrawl()']")).click();
        int randomNumber=(random.nextInt(65536)-32768)%5000;
        driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys(Integer.toString(randomNumber));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    public void checkBalance(){
        WebElement balance = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]"));
        balance.getText();
    }


}


