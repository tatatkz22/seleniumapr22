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

public class ddtExcel {

    private String baseurl;
    private WebDriver driver;


    @BeforeMethod
    public void setup() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.setHeadless(true);
        driver = new ChromeDriver(option);


        baseurl = "https://datamateinc.com/registration";
        driver.manage().window().maximize();



    }

        @Test(dataProvider = "testdata")
        public void delegatesDemo(String delName, String delLastName) throws InterruptedException {

            driver.get(baseurl);

            forms.regPageElements.txtDelegateName(driver).clear();
            forms.regPageElements.txtDelegateLast(driver).clear();


            forms.regPageElements.txtDelegateName(driver).sendKeys(delName);
            forms.regPageElements.txtDelegateLast(driver).sendKeys(delLastName);


           System.out.println("Delegate Registered Successfully");
        }
        @AfterMethod
        public void teardown () {

        driver.quit();
        }
        @DataProvider(name = "testdata")
        public Object[][] testDataExample() {
            ReadExcelFile configuration = new ReadExcelFile("src/main/resources/delegates.xlsx");
            int rows = configuration.getRowCount(0);
            Object[][] delegate_Details = new Object[rows][2];

            for (int i = 0; i < rows; i++) {
                delegate_Details[i][0] = configuration.getData(0, i, 0);
                delegate_Details[i][1] = configuration.getData(0, i, 1);
            }
            return delegate_Details;
        }
    }
