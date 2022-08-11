package mainPackge;

import java.net.MalformedURLException;
import java.net.URL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class gridExample {
	
	static WebDriver driver = null; 
	@Parameters({"browser","port"}) 
	
	
	@BeforeMethod 
	public void beforeTest(String browser, String port) { 
	
		//compares the value of parameter name with Firefox, if its firefox then it will launch firefox and run the script. 
		if (browser.equalsIgnoreCase("firefox"))
	
				{
		
						WebDriverManager.firefoxdriver().setup();
						driver = new FirefoxDriver();

						DesiredCapabilities capabilities = new DesiredCapabilities();
						capabilities.setBrowserName("firefox");
						capabilities.setPlatform(Platform.WIN10);
						capabilities.setVersion("ANY");



				try {
		
						driver=new RemoteWebDriver(new URL(port.concat("/wd/hub")),capabilities);

					} catch (MalformedURLException e) {

					// TODO Auto-generated catch block
					e.printStackTrace();
						 }
	
	

	         		 }
			else if (browser.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
				DesiredCapabilities capabilities1 = new DesiredCapabilities();
				capabilities1.setBrowserName("chrome");
				capabilities1.setPlatform(Platform. WIN10);
				capabilities1.setVersion("ANY");

				try {
		
				driver=new RemoteWebDriver(new URL(port.concat("/wd/hub")),capabilities1);
	
				} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}


			}
		else if (browser.equalsIgnoreCase("edge"))
				{
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				DesiredCapabilities capabilities2 = new DesiredCapabilities();
				capabilities2.setBrowserName("edge");
				capabilities2.setPlatform(Platform.WIN10);
				capabilities2.setVersion("ANY");

				try {
		
				driver=new RemoteWebDriver(new URL(port.concat("/wd/hub")),capabilities2);
	
	
				} catch (MalformedURLException e1)
	
					{
				// TODO Auto-generated catch block
				e1.printStackTrace();
					}
			}
	else 
			{ throw new IllegalArgumentException("The Browser Type is Undefined");
			   }

					driver.get("https://datamateinc.com/registration");


			}
	
	
	
	
	
	
	@Test 
	public void openDatamateRegForm() throws InterruptedException {
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String urltest = driver.getCurrentUrl();

		System.out.println("***********The URL is printed here**********");
		System.out.println(urltest);

		String courseSelect = driver.findElement(By.xpath("//*[@id='wpforms-3337-field_16-container']/label")).getText();
		System.out.println("***********The LabelName is here**********");
		System.out.println(courseSelect);

		Thread.sleep(3000);

	}


		@AfterMethod //close
	public void afterTest() 
	{ 
		try { 
				driver.wait(5000); 
			} 
		catch (Exception e){ 
			
				driver.quit(); 
	} 

	} 

}




