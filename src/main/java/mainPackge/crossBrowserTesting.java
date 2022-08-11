package mainPackge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class crossBrowserTesting {

    public WebDriver driver;

    String URL = "https://lambdatest.github.io/sample-todo-app/";
    String Node = "http://10.0.0.140:4444/wd/hub";
    boolean status = false;

    @BeforeClass
    public void testSetUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.whitelistedIps", "");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

         DesiredCapabilities caps = new DesiredCapabilities();
         caps.setBrowserName("chrome");
         driver = new RemoteWebDriver(new URL(Node), caps);

    }

    @Test
    public void test_ToDo_App() throws InterruptedException {
           driver.navigate().to(URL);
          driver.manage().window().maximize();
             try {

            /* Let's mark done first two items in the list. */

            driver.findElement(By.name("li1")).click();
            driver.findElement(By.name("li2")).click();
                  /* Let's add an item in the list. */
            driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");
            driver.findElement(By.id("addbutton")).click();

            /* Let's check that the item we added is added in the list. */
            String enteredText = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[6]/span")).getText();

            if (enteredText.equals("Yey, Let's add it to list")) {
                       status = true;
                      }
            System.out.println("Selenium Grid 4 Standalone Testing Is Complete");
        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {

            driver.quit();
        }

    }
}

