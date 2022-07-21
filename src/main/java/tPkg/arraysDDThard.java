package tPkg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

@DataProvider(name ="Delegates")
    public Object[][] DelegatesDetails(){

         Object [][] DelePersonaInf = new Object[4][2];

         DelePersonaInf[0][0] ="Fikile";
         DelePersonaInf[0][1] ="fikile1";


         DelePersonaInf[1][0] ="Piet";
         DelePersonaInf[1][1] ="Piet1";


         DelePersonaInf[2][0] ="Nkosi";
         DelePersonaInf[2][1] ="Nkosi1";


         DelePersonaInf[3][0] ="Tim";
         DelePersonaInf[3][1] ="Tim1";

    return DelePersonaInf;

}


@Test(dataProvider ="Delegates")
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
    public void closeBrowser() {

        driver.close();

    }


}
