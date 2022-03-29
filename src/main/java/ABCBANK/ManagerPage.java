package ABCBANK;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class ManagerPage extends BrowserConfig{


    public ManagerPage(){
        PageFactory.initElements(driver,this);
    }
    public void ClickAddCustomer() throws InterruptedException {
        driver.findElement(By.xpath("//button[@ng-class='btnclass1']")).click();
    }
    By OpenAccount=By.xpath("//button[@ng-class='btnClass2']");
    public void ClickOpenAccount() throws InterruptedException {
        driver.findElement(By.xpath("//button[@ng-class='btnclass2']")).click();
    }
    public void ClickOpenCustomer() throws InterruptedException {
        driver.findElement(By.xpath("//button[@ng-class='btnclass3']")).click();
    }

}
