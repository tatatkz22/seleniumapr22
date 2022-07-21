package tPkg;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class openGoogleTestNG {


    private String baseurl;
    private WebDriver driver;

    @BeforeMethod
    @Story("BDD Story testing")
    public void LoadUrlPage() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseurl = "https://google.com";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }


    @Test
    @Epic("Allure EPIC Testing")
    @Feature("Feature Testing EPIC")
    public void openGooglePage() throws InterruptedException, IOException {

        driver.get(baseurl);
        System.out.println("TestNG opening Google");
        Thread.sleep(3000);

        Actions action = new Actions(driver);

        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));

        action.doubleClick(element).perform();
        Thread.sleep(3000);

        //calling screenshot method
        takeScreen();

        action.sendKeys("wikipedia").perform();
        action.sendKeys(Keys.ENTER).perform();


        for(int i=0;i<12;i++){
            action.sendKeys(Keys.TAB).perform();
        }
    //calling screenshot method
              Thread.sleep(4000);


    }

public void takeScreen() throws IOException {
    TakesScreenshot ts = (TakesScreenshot)driver;
    File srcFile = ts.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(srcFile, new File("./Screenshots/"+System.currentTimeMillis()+".png"));

}


          /*  @AfterMethod
            public void closeBrowser() {

                driver.close();

            }

*/


}