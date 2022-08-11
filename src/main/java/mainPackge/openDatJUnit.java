package mainPackge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openDatJUnit {

    private String baseurl;
    private WebDriver driver;

    @Before
    public void setup() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseurl = "https://the-internet.herokuapp.com/javascript_alerts";
        driver.manage().window().maximize();
        Thread.sleep(3000);



    }



    @Test
    public void opDM() throws InterruptedException {

        driver.get(baseurl);
        System.out.println("JUnit opening Datamate");


    }





    @After
    public void closeBrwse(){

        driver.close();

    }













}
