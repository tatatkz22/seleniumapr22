package tPkg;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;


public class openDatTestNG {


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


    @Test(description = "Opening Datamate.com registration form")
    @Description("Test Description: Load website with base URL and maximize the window")
    public void opDM() throws InterruptedException {
        driver.get(baseurl);

        Thread.sleep(3000);

        String urltest = driver.getCurrentUrl();

        System.out.println("***********The URL is printed here**********");
        System.out.println(urltest);

        String courseSelect = driver.findElement(By.xpath("//*[@id='wpforms-3337-field_16-container']/label")).getText();
        System.out.println("***********The LabelName is here**********");
        System.out.println(courseSelect);

        Thread.sleep(3000);


    }

/*

    public void takeScreenShot(String name) {
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreensh WebDot)river.Window.getCurrentDriver()).getScreenshotAs(OutputType.BYTES) ));
    }
*/
            @Step("Closing the window")
            @AfterMethod
            public void closeBrwse() {

                driver.close();

            }




}