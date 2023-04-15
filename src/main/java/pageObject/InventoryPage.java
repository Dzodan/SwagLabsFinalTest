package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage{
        @FindBy (className ="product_sort_container" )
        WebElement sortDropDown;
        @FindBy (id = "add-to-cart-sauce-labs-onesie")
     public    WebElement Onesie;
       @FindBy (id = "add-to-cart-sauce-labs-bike-light")
     public   WebElement Bikelight;
       @FindBy (id = "add-to-cart-test.allthethings()-t-shirt-(red)")
       WebElement TshirtRed;
       @FindBy (css = "#shopping_cart_container span")
       WebElement cart;
       @FindBy (id = "checkout")
       WebElement checkout;
       @FindBy (id = "remove-sauce-labs-onesie")
       WebElement RemoveOnesie;
       @FindBy (id = "remove-sauce-labs-bike-light")
       WebElement RemoveBikeLight;
       @FindBy (id = "continue-shopping")
       WebElement ContinueShoppingFromCart;

       public  InventoryPage (ChromeDriver driver){
           this.driver=driver;
           PageFactory.initElements(driver, this);

       }
       public String Cart(){
           return cart.getText();

       }

       public void  AddOnesie (){
           Onesie.click();
       }
       public void AddBikelight(){
           Bikelight.click();
       }
       public void AddTshirtRed() {
           TshirtRed.click();
       }
       public void ClickonCart(){
                 cart.click();
           }
           public void ClickCheckout(){
           checkout.click();
           }
           public void SortItemByText(String text){
               Select drop = new Select(sortDropDown);
               drop.selectByVisibleText(text);

           }
           public void ClickRemoveOnesie(){
           RemoveOnesie.click();
           }
           public void ClickRemoveBikeLight(){
           RemoveBikeLight.click();
           }
           public void ClickContinueShoppingOnCart(){
           ContinueShoppingFromCart.click();
           }

       }

