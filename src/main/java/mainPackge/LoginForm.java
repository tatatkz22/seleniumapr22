package mainPackge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ReadExcelFile;

public class LoginForm {


    private String baseurl;
    private WebDriver driver;


    @BeforeMethod
    public void setup() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.setHeadless(true);
        driver = new ChromeDriver(option);
        baseurl = "https://demosite.executeautomation.com/Login.html";
        driver.manage().window().maximize();

    }

    @Test(dataProvider="TestDataFeed")
    public void Logins (String Username, String Paswd) throws InterruptedException {
        driver.get(baseurl);


        //clearing the input boxes before typing
        forms.regPageElements.txtUsername(driver).clear();
        forms.regPageElements.txtPassword(driver).clear();

        forms.regPageElements.txtUsername(driver).sendKeys(Username);
        forms.regPageElements.txtPassword(driver).sendKeys(Paswd);

    }

@DataProvider
public Object[][] TestDataFeed() {

    ReadExcelFile config = new ReadExcelFile("src/main/resources/usernames.xlsx");
    int rows = config.getRowCount(0);
    Object[][] LoginDetails = new Object[rows][2];
    for(int i=0;i<rows;i++)
    {
        LoginDetails[i][0] = config.getData(0, i, 0);
        LoginDetails[i][1] = config.getData(0, i, 1);
    }
    return LoginDetails;
}


@AfterMethod
    public void TearDown(){

        driver.close();
}
}


