package forms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class rePageFactoryElements {

    @FindBy(linkText ="Training")
    public WebElement tpfTraining;

    @FindBy(partialLinkText="Database")
    public WebElement tpfDatabase;

    @FindBy(css="#default-btn-86dfb65d5a95023ba5557de2b61b07ef > span")
    public WebElement tpfRegistrationBtn;

    @FindBy(id="wpforms-3337-field_19")
    public WebElement tpfTitle;

    @FindBy(xpath="//*[@id='wpforms-3337-field_0']")
    public WebElement tpfDelegateName;

    @FindBy(xpath ="/html/body/div[1]/div[3]/div/div[2]/div/div/div/section[3]/div/div[1]/div/div/div/div/form/div[1]/div[2]/div[1]/div[2]/input")
    public WebElement tpfDelegateLastName;


}
