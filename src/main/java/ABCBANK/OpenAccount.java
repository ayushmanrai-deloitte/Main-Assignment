package ABCBANK;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;
public class OpenAccount extends BrowserConfig {
    public String alertmsg;
    Random random=new Random();
    public OpenAccount(){
        PageFactory.initElements(driver,this);
    }
    By SelectCustomer = By.xpath("//select[@id='userselect']");
    By SelectCurrency = By.xpath("//select[@id='currency']");
    By SubmitBtn = By.xpath("//button[@type='submit']");
    public void SelectCustomer(String customer){
        Select selectcustomer = new Select(driver.findElement(SelectCustomer));
        selectcustomer.selectByVisibleText(customer);
    }
    public void SelectCurrency(){
        String currency = "Dollar";
        Select selectcurrency = new Select(driver.findElement(SelectCustomer));
    }
    public void Submit(){
        driver.findElement(SubmitBtn).click();
        driver.switchTo().alert().accept();
    }
}