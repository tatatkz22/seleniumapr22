package EX1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class arraysDDT {

    public WebDriver driver;

    @BeforeMethod
    public void setup() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://datamateinc.com/registration");
        driver.manage().window().maximize();
        Thread.sleep(3000);


    }

    @DataProvider(name = "regisForm")
    public Object[][] LoginDetails(){

        Object[][] LogiData = new Object[4][2];

        LogiData[0][0] ="Nkosi";
        LogiData[0][1]="Nkosi1";


        LogiData[1][0]="Piet";
        LogiData[1][1]="piet1";

        LogiData[2][0]="Thato";
        LogiData[2][1]="thato1";

        LogiData[3][0]="Tau";
        LogiData[3][1]="tau1";


        return LogiData;


    }




    @Test(dataProvider = "regisForm")
    public void LoginTest(String Username, String Passwd) throws InterruptedException {

        Thread.sleep(1000);
        //clearing the textboxes before typing new username and password
        forms.regPageElements.txtDelegateName(driver).clear();
        forms.regPageElements.txtDelegateLast(driver).clear();


        //registration page
        forms.regPageElements.txtDelegateName(driver).sendKeys(Username);
        forms.regPageElements.txtDelegateLast(driver).sendKeys(Passwd);
        Thread.sleep(3000);

    }

    @AfterMethod
    public void TearDown(ITestResult result) throws IOException {

        //takes a screenshot for a failure, creates a directory first
        if (result.getStatus() == ITestResult.FAILURE ){
            TakesScreenshot ts = (TakesScreenshot)driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File("./ScreenShots/"+ System.currentTimeMillis()+".png"));


        }

        else
        //takes a screenshot for a pass, creates a directory first.
        {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir");
            FileUtils.copyFile(scrFile, new File(currentDir + "\\TestResults\\" + System.currentTimeMillis() + ".png"));

        }
        driver.quit();
    }
}


