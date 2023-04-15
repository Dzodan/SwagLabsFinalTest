package Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.CheckoutStepPage;
import pageObject.InventoryPage;
import pageObject.LoginPage;

public class InventoryTest extends BaseTest {
    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CheckoutStepPage checkoutStepPage;
    @BeforeMethod
    public void Before (){
        driver = openWebDriver();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        checkoutStepPage = new CheckoutStepPage(driver);
    }

   //  2 a ZADATAK
    @Test
    public void  SortAndBuy3CheapestProducts ()
    {
         loginPage.Login("standard_user","secret_sauce");
         inventoryPage.SortItemByText("Price (low to high)");
         inventoryPage.AddOnesie();
         inventoryPage.AddBikelight();
         inventoryPage.AddTshirtRed();
         Assert.assertEquals(inventoryPage.Cart(),"3");
    }

    // 2 b ZADATAK

    @Test
    public void Buy2ProductsAndDeleteBoth()
    {
        loginPage.Login("standard_user","secret_sauce");
        inventoryPage.AddOnesie();
        inventoryPage.AddBikelight();
        inventoryPage.ClickonCart();
        inventoryPage.ClickRemoveOnesie();
        inventoryPage.ClickRemoveBikeLight();
        inventoryPage.ClickContinueShoppingOnCart();
        Assert.assertEquals(inventoryPage.Onesie.isDisplayed(),true);
        Assert.assertEquals(inventoryPage.Bikelight.isDisplayed(),true);
    }
       // 3a ZADATAK
    @Test
    public void ItemTotal (){
        loginPage.Login("standard_user","secret_sauce");
        inventoryPage.AddOnesie();
        inventoryPage.AddTshirtRed();
        inventoryPage.AddBikelight();
        inventoryPage.ClickonCart();
        inventoryPage.ClickCheckout();
        checkoutStepPage.EnterFirstName("Jovan");
        checkoutStepPage.EnterLastName("Dzodan");
        checkoutStepPage.EnterPostalCode("11000");
        checkoutStepPage.ClickContinue();
        checkoutStepPage.ItemTotal();
        Assert.assertEquals(checkoutStepPage.ItemTotal(),"Item total: $33.97");

    }
    //   3b ZADATAK
      @Test
      public void TotalPrice (){
          loginPage.Login("standard_user","secret_sauce");
          inventoryPage.AddOnesie();
          inventoryPage.AddTshirtRed();
          inventoryPage.AddBikelight();
          inventoryPage.ClickonCart();
          inventoryPage.ClickCheckout();
          checkoutStepPage.EnterFirstName("Jovan");
          checkoutStepPage.EnterLastName("Dzodan");
          checkoutStepPage.EnterPostalCode("11000");
          checkoutStepPage.ClickContinue();
          checkoutStepPage.TotalPrice();
          Assert.assertEquals(checkoutStepPage.TotalPrice(),"Total: $36.69");
      }
      //5 ZADATAK
    @Test
    public void FinishOrder(){
        loginPage.Login("standard_user","secret_sauce");
        inventoryPage.AddOnesie();
        inventoryPage.AddTshirtRed();
        inventoryPage.AddBikelight();
        inventoryPage.ClickonCart();
        inventoryPage.ClickCheckout();
        checkoutStepPage.EnterFirstName("Jovan");
        checkoutStepPage.EnterLastName("Dzodan");
        checkoutStepPage.EnterPostalCode("11000");
        checkoutStepPage.ClickContinue();
        checkoutStepPage.ClickFinish();
        checkoutStepPage.OrderCompleted();
        Assert.assertEquals(checkoutStepPage.OrderCompleted(),"Thank you for your order!");
    }
@AfterMethod
    public void After ()
{
    driver.quit();
}
}
