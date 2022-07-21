package tPkg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class regDatPageFactoryTestCase {

    public static void main(String[]args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://datamateinc.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        forms.rePageFactoryElements pf = PageFactory.initElements(driver,forms.rePageFactoryElements.class);

        //clicking training
       pf.tpfTraining.click();
        Thread.sleep(3000);
       pf.tpfDatabase.click();
        Thread.sleep(2000);

       pf.tpfRegistrationBtn .click();
        Thread.sleep(2000);

        //registration page
        pf.tpfTitle.sendKeys("Mr");
        pf.tpfDelegateName .sendKeys("Smith");
        pf.tpfDelegateLastName .sendKeys("Fikile");

        Thread.sleep(3000);


       driver.quit();

}
}
