package EX1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openDatJUnit {

    private String baseurl;
    private WebDriver driver;

    @Before
    public void setup() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseurl = "https://datamateinc.com/";
        driver.manage().window().maximize();
        Thread.sleep(3000);



    }



    @Test
    public void opDM() throws InterruptedException {

        driver.get(baseurl);

        driver.findElement(By.linkText("Training")).click();
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Database")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#default-btn-86dfb65d5a95023ba5557de2b61b07ef > span")).click();
        Thread.sleep(2000);

        //registration page
        driver.findElement(By.id("wpforms-3337-field_19")).sendKeys("Mr");
        driver.findElement(By.xpath("//*[@id='wpforms-3337-field_0']")).sendKeys("Fikile");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div/section[3]/div/div[1]/div/div/div/div/form/div[1]/div[2]/div[1]/div[2]/input")).sendKeys("Smith");
        Thread.sleep(3000);


    }





    @After
    public void closeBrwse(){

        driver.close();

    }













}
