package tPkg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
        driver = new ChromeDriver();
        baseurl = "https://datamateinc.com/registration";
        driver.manage().window().maximize();

        Thread.sleep(3000);

    }

        @Test(dataProvider = "testdata")
        public void demoClass(String delName, String delLastName) throws InterruptedException {

            driver.get(baseurl);
            Thread.sleep(2000);
            forms.regPageElements.txtDelegateName(driver).clear();
            forms.regPageElements.txtDelegateLast(driver).clear();
            Thread.sleep(1000);

            forms.regPageElements.txtDelegateName(driver).sendKeys(delName);
            forms.regPageElements.txtDelegateLast(driver).sendKeys(delLastName);
            Thread.sleep(3000);

            Assert.assertTrue(driver.getTitle().matches("Datamate Registration Form | Offering the Best Selenium Training Course in SA"), "Missing Paramater");
            System.out.println("Login successful");
        }
        @AfterMethod
        void ProgramTermination () {
            driver.quit();
        }
        @DataProvider(name = "testdata")
        public Object[][] testDataExample() {
            ReadExcelFile configuration = new ReadExcelFile("src/main/resources/usernames.xlsx");
            int rows = configuration.getRowCount(0);
            Object[][] signin_credentials = new Object[rows][2];

            for (int i = 0; i < rows; i++) {
                signin_credentials[i][0] = configuration.getData(0, i, 0);
                signin_credentials[i][1] = configuration.getData(0, i, 1);
            }
            return signin_credentials;
        }
    }
