package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class LoginAndShopping extends TestBaseRapor{


    @Test (priority = 1)
    public void urlTest(){
        extentTest = extentReports.createTest("The user goes to the Hepsiburada.com homepage and the url is tested to be correct.");

        extentTest.info("page opens");
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));

        String expectedUrl = "https://www.hepsiburada.com/";

        String actualUrl = Driver.getDriver().getCurrentUrl();


        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("verified that the url of the visited page is www.hepsiburada.com");

    }

    @Test (priority = 2)
    public void loginAndShopping(){
        extentTest = extentReports.createTest("user logs in, adds products to the cart, checks that products have been added to the cart and deletes them");

        Homepage homepage = new Homepage();

        extentTest.info("user logs in with valid account information");
        homepage.login();

        homepage.searchBox.sendKeys("computer",Keys.ENTER);

        ReusableMethods.hover(homepage.productName);

        String expectedProductName = homepage.productName.getText();

        ReusableMethods.actionsClick(homepage.firstProduct);

        ReusableMethods.switchToWindowHandle(Driver.getDriver().getWindowHandles());

        ReusableMethods.scrollToElement(homepage.addToCard);

        extentTest.info("user adds product to cart");
        homepage.addToCard.click();

        ReusableMethods.waitForVisibility(homepage.productInCardPass,20);

        Assert.assertTrue(homepage.productInCardPass.isDisplayed());
        extentTest.pass("Verified that the product has been successfully added to the cart");

        homepage.goToCard.click();

        String actualProductName = homepage.productInCart.getText();

        Assert.assertEquals(actualProductName,expectedProductName);

        homepage.deleteProductsInCart.click();

        extentTest.info("The user deletes the products added to the cart.");
        homepage.allDelete.click();

        String expected = "Sepetin şu an boş";

        String actual = homepage.cardIsBlank.getText();

        Assert.assertEquals(actual,expected);
        extentTest.pass("Confirmed that products have been deleted successfully");

        ReusableMethods.waitForClickablility(homepage.cardIsEmptyInfo,20);

        homepage.cardIsEmptyInfo.click();

        extentTest.info("user log out");
        homepage.profileIcon.click();

        homepage.logoutIcon.click();

    }
}
