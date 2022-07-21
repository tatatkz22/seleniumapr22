package EX1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionKeys {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://www.google.com");

        // Create object of Action class
        Actions action = new Actions(driver);

        // Sendkeys using Action class object

       WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));

       action.doubleClick(element).perform();
        Thread.sleep(3000);
       action.sendKeys("selenium").perform();
        Thread.sleep(3000);
       action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(10000);

        for(int i=0; i<10; i++){
            action.sendKeys(Keys.TAB).perform();
        }



        Thread.sleep(10000);
        driver.close();

    }

}


