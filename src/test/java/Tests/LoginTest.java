package Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.LoginPage;

public class LoginTest extends BaseTest {
    ChromeDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void SetUp() {
        driver = openWebDriver();
        loginPage = new LoginPage(driver);
    }
       // 1 ZAdatak
    @Test
    public void ValidLogin() {
        loginPage.Login("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void WrongPasswordLogin() {
        loginPage.Login("standard_user", "bezsosa");
        Assert.assertEquals(loginPage.getTextmessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void WrongUsernameLogin() {
        loginPage.Login("nestandardni", "secret_sauce");
        Assert.assertEquals(loginPage.getTextmessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void NoUsernameLogin() {
        loginPage.Login("", "secret_sauce");
        Assert.assertEquals(loginPage.getTextmessage(), "Epic sadface: Username is required");
    }
    @Test
    public void NoPasswordLogin() {
        loginPage.Login("standard_user", "");
        Assert.assertEquals(loginPage.getTextmessage(), "Epic sadface: Password is required");
    }

        @AfterMethod
        public void After ()
        {
            driver.quit();
        }
    }
