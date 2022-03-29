import ABCBANK.BrowserConfig;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ABCBANK.AddCustomer;
import ABCBANK.Login;
import ABCBANK.ManagerPage;
import ABCBANK.OpenAccount;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class AddCustomerTest extends BrowserConfig {
    OpenAccount openacc;
    Login loginPage;
    ManagerPage managerHomePage;
    AddCustomer addCustomer;
    public AddCustomerTest(){
        PageFactory.initElements(driver,this);
    }
    @BeforeMethod
    public void setup() throws InterruptedException {
        initialize();
        openacc = new OpenAccount();
        loginPage = new Login();
        managerHomePage = new ManagerPage();
        addCustomer = new AddCustomer();
        loginPage.ClickManagerLogin();
        managerHomePage.ClickAddCustomer();
    }
    @Test
    public void AddCustomerTest() throws IOException {
        File file = new File("./src/main/resources/bankdata.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = wb.getSheet("data");
        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getLastCellNum();
        String first = null;
        String last = null;
        String pincode = null;
        for(int i=1;i<rows;i++){
            for (int j=0;j<cols;j++){
                if(j==0){
                    first=sheet.getRow(i).getCell(j).getStringCellValue();
                }
                if(j==1){
                    last = sheet.getRow(i).getCell(j).getStringCellValue();
                }
                if(j==2){
                    pincode = sheet.getRow(i).getCell(j).getStringCellValue();
                }
            }
            addCustomer.AddCustomerDetail(first,last,pincode);
            System.out.println(addCustomer.alertmessage);
        }
    }



}

