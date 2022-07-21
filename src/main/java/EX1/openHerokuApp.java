package EX1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class openHerokuApp {

    private String baseurl;
    private WebDriver driver;

    @Before
    public void setup() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseurl = "https://the-internet.herokuapp.com";
        driver.manage().window().maximize();
        Thread.sleep(3000);



    }



    @Test
    public void openHeroWebsite() throws InterruptedException {

        driver.get(baseurl+"/javascript_alerts");

        WebElement jsAlert = driver.findElement(By.xpath(".//*[@id='content']/div/ul/li[1]/button"));
        WebElement jsConfirm = driver.findElement(By.xpath(".//*[@id='content']/div/ul/li[2]/button"));
        WebElement jsPrompt = driver.findElement(By.xpath(".//*[@id='content']/div/ul/li[3]/button"));

        Thread.sleep(4000);
        //Clicks Ok
        jsAlert.click();
        driver.switchTo().alert().accept();
        Thread.sleep(4000);

        jsConfirm.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        Thread.sleep(4000);

        jsPrompt.click();
        driver.switchTo().alert().sendKeys("selenium");
        driver.switchTo().alert().accept();
        Thread.sleep(4000);


    }





    @After
    public void closeBrwser(){

        driver.close();

    }













}
