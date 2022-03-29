package ABCBANK;
import ABCBANK.BrowserConfig;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class AddCustomer extends BrowserConfig {
    public String alertmessage;
    public AddCustomer() {
        PageFactory.initElements(driver, this);
    }

    public void AddCustomerDetail(String fname, String lname, String pcode) {
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(fname);
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lname);
        driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys(pcode);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}



