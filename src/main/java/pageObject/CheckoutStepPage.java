package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepPage extends BasePage {

    @FindBy ( id="first-name")
    WebElement firstName;
    @FindBy (id="last-name")
    WebElement lastName;
    @FindBy (id = "postal-code")
    WebElement postalCode;

    @FindBy (id= "continue")
    WebElement continueButton;
    @FindBy (id = "finish")
    WebElement finishButton;

    @FindBy (className = "complete-header")
    WebElement completedOrder;

    @FindBy(css = "div.summary_subtotal_label")
    WebElement itemTotalprice;

    @FindBy(css = "div.summary_total_label")
    WebElement TotalEndPrice;
    public CheckoutStepPage (ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }
    public void  EnterFirstName(String name){
        firstName.sendKeys(name);
    }
    public void EnterLastName (String last){
        lastName.sendKeys(last);
    }
    public void EnterPostalCode (String postal){
        postalCode.sendKeys(postal);
    }
     public void ClickContinue (){
        continueButton.click();
     }
     public void ClickFinish (){
        finishButton.click();
     }
     public String OrderCompleted (){
        return completedOrder.getText();
     }
     public String ItemTotal(){
        return itemTotalprice.getText();
     }
     public String TotalPrice(){
        return TotalEndPrice.getText();
     }
}
