package ABCBANK;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class CustomerPage extends BrowserConfig{
    public CustomerPage(){
        PageFactory.initElements(driver,this);
    }
    By selectname = By.xpath("//select");
    By login = By.xpath("//button[@type='submit']");
    public void SelectAccount(String name){
        Select customerName = new Select(driver.findElement(selectname));
        customerName.selectByVisibleText(name);
    }
    public  void LoginBtn(){
        driver.findElement(login).click();
    }
}

