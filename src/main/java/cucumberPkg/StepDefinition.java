package cucumberPkg;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.remote.Augmenter;

import java.time.Duration;

public class StepDefinition {
    public WebDriver driver;
    public String baseurl;
    @Given("Open the Datamate URL")
    public void open_the_datamate_url() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseurl = "https://datamateinc.com/registration";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

    }

    @When("You are on the registration Form")
    public void you_are_on_the_registration_form() throws InterruptedException {
        driver.get(baseurl);
        Thread.sleep(1000);

    }



    @Then("Enter the First Name")
    public void enter_the_first_name() {
        forms.regPageElements.txtDelegateName(driver).sendKeys("Piet");

    }
    @Then("Enter the Last Name")
    public void enter_the_last_name() {
        forms.regPageElements.txtDelegateLast(driver).sendKeys("Smith");

    }
    @Then("Close the browser")
    public void close_the_browser() {
        driver.close();
           }


}
