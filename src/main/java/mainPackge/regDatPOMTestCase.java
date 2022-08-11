package mainPackge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class regDatPOMTestCase {

    public static void main(String[]args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://datamateinc.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //clicking training
        forms.regPageElements.txtTraining(driver).click();
        Thread.sleep(3000);
        forms.regPageElements.txtDatabase(driver).click();
        Thread.sleep(2000);

        forms.regPageElements.txtRegistrationLink(driver).click();
        Thread.sleep(2000);

        //registration page
        forms.regPageElements.txtTitle(driver).sendKeys("Mr");
        forms.regPageElements.txtDelegateName(driver).sendKeys("Fikile");
        forms.regPageElements.txtDelegateLast(driver).sendKeys("Smith");
        Thread.sleep(3000);


       driver.quit();

}
}
