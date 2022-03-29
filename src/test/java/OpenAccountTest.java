import ABCBANK.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import  ABCBANK.AddCustomer;
import ABCBANK.Login;
import ABCBANK.ManagerPage;
import ABCBANK.OpenAccount;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class OpenAccountTest extends BrowserConfig {
    OpenAccount openacc;
    Login loginPage;
    AddCustomer addcustomer;
    ManagerPage managerHomePage;
    public OpenAccountTest(){
        PageFactory.initElements(driver,this);
    }
    @BeforeMethod
    public void setup() throws InterruptedException {
        initialize();
        openacc = new OpenAccount();
        loginPage = new Login();
        addcustomer = new AddCustomer();
        managerHomePage = new ManagerPage();
        loginPage.ClickManagerLogin();
        managerHomePage.ClickAddCustomer();
    }


    @Test
    public void OpenAccountTest() throws IOException, InterruptedException {
        File file = new File("./src/main/resources/bankdata.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = wb.getSheet("data");
        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getLastCellNum();
        String first = null;
        String last = null;
        String pincode = null;
        int n=0;
        while (n<rows) {
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (j == 0) {
                        first = sheet.getRow(i).getCell(j).getStringCellValue();
                    }
                    if (j == 1) {
                        last = sheet.getRow(i).getCell(j).getStringCellValue();
                    }
                    if (j == 2) {
                        pincode = sheet.getRow(i).getCell(j).getStringCellValue();
                    }
                }
                addcustomer.AddCustomerDetail(first, last, pincode);
                System.out.println(addcustomer.alertmessage);
                String customer = first + " " + last;
                managerHomePage.ClickOpenAccount();
                openacc.SelectCustomer(customer);
                openacc.SelectCurrency();
                openacc.Submit();
                System.out.println(openacc.alertmsg);
                managerHomePage.ClickAddCustomer();
                n++;
            }
        }

    }
}
