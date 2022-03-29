import ABCBANK.BrowserConfig;
import ABCBANK.Login;
import org.testng.Assert;
import org.testng.annotations.*;
public class LoginTest extends BrowserConfig {
    Login loginPage;
    public LoginTest(){
        super();
    }
    @BeforeMethod
    public void setup(){
        initialize();
        loginPage = new Login();
    }
    @Test(priority = 1)
    public void titletest(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"XYZ Bank");
    }
    @Test(priority = 2)
    public void managerlogintest() throws InterruptedException {
        loginPage.ClickManagerLogin();
    }
    @Test(priority = 3)
    public void customerlogintest() throws InterruptedException {
        loginPage.ClickCustomerlogin();
    }

}

