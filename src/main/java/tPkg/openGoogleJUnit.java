package tPkg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Timeout;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openGoogleJUnit {

    private String baseurl;
    private WebDriver driver;

    @Before
    public void setup() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseurl = "https://google.com/";
        driver.manage().window().maximize();
           Thread.sleep(3000);



    }



    @Test
    public void opDM() throws InterruptedException {

        driver.get(baseurl);
        System.out.println("JUnit opening Google");


    }





    @After
    public void closeBrwse(){

        driver.close();

    }













}
