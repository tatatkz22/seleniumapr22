package mainPackge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class paralleTestClass {
    public WebDriver driver;

    @Test
    public void FireFoxBrowser() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        Thread.sleep(2000);
        driver.get("https://google.com");
        driver.quit();

    }

    @Test
    public void ChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.quit();

    }

    @Test
    public void MicrosoftEdgeBrowser(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://google.com");
        driver.quit();
    }




}
