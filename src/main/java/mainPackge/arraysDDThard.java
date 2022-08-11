package mainPackge;

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

public class arraysDDThard {
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

@DataProvider
    public Object[][] DelegatesDetails(){

         Object [][] DelePersonaInf = new Object[4][2];

         DelePersonaInf[0][0] ="Fikile";
         DelePersonaInf[0][1] ="fikile1";


         DelePersonaInf[1][0] ="Piet";
         DelePersonaInf[1][1] ="Piet1";


         DelePersonaInf[2][0] ="Nkosi";
         DelePersonaInf[2][1] ="Nkosi1";


         DelePersonaInf[3][0] ="Tim";
         DelePersonaInf[3][0] ="Tim1";

    return DelePersonaInf;

}


@Test(dataProvider ="DelegatesDetails")
    public void delegRegistraForm(String delName, String delLastName) throws InterruptedException {
    driver.get(baseurl);
        Thread.sleep(2000);
    forms.regPageElements.txtDelegateName(driver).clear();
    forms.regPageElements.txtDelegateLast(driver).clear();
    Thread.sleep(1000);

    forms.regPageElements.txtDelegateName(driver).sendKeys(delName);
    forms.regPageElements.txtDelegateLast(driver).sendKeys(delLastName);
    Thread.sleep(3000);
}



    @AfterMethod
    public void closeBrowser(ITestResult result) throws IOException {


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

        driver.close();

    }


}
