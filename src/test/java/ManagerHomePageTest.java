import ABCBANK.BrowserConfig;
import ABCBANK.Login;
import ABCBANK.ManagerPage;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
public class ManagerHomePageTest extends BrowserConfig {
    ManagerPage mhome;
    Login login;
    public ManagerHomePageTest(){
        super();
    }
    @BeforeMethod
    public void setup(){
        initialize();
        mhome = new ManagerPage();
        login = new Login();
        login.ClickManagerLogin();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test(priority = 1)
    public void addcustomertest() throws InterruptedException {
        mhome.ClickAddCustomer();
    }
    @Test(priority = 2)
    public void openaccounttest() throws InterruptedException {
        mhome.ClickOpenAccount();
    }

    @Test(priority = 3)
    public void customerstest() throws InterruptedException{
        mhome.ClickOpenAccount();
    }
    @Test(priority = 4)
    public void homebtntest(){
        login.ClickHome();
    }

}

