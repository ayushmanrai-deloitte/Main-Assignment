import ABCBANK.BrowserConfig;
import ABCBANK.CustomerPage;
import ABCBANK.Login;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
class CustomerHomePageTest extends BrowserConfig {
    Login login;
    CustomerPage chome;
    public CustomerHomePageTest(){
        super();
    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        initialize();
        login = new Login();
        chome = new CustomerPage();
        login.ClickCustomerlogin();
    }
    @Test(priority = 1)
    public void selectcustomer(){
        chome.SelectAccount("Harry Potter");
        chome.LoginBtn();
    }

}

