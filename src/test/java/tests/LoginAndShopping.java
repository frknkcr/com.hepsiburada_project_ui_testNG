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
        extentTest = extentReports.createTest("asd");

        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));

        String expectedUrl = "https://www.hepsiburada.com/";

        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

    }

    @Test (priority = 2)
    public void loginAndShopping(){
        extentTest = extentReports.createTest("asd");

        Homepage homepage = new Homepage();

        homepage.login();

        homepage.searchBox.sendKeys("computer",Keys.ENTER);

        ReusableMethods.hover(homepage.productName);

        String expectedProductName = homepage.productName.getText();

        ReusableMethods.actionsClick(homepage.firstProduct);

        ReusableMethods.switchToWindowHandle(Driver.getDriver().getWindowHandles());

        ReusableMethods.scrollToElement(homepage.addToCard);

        homepage.addToCard.click();

        ReusableMethods.waitForVisibility(homepage.productInCardPass,20);

        Assert.assertTrue(homepage.productInCardPass.isDisplayed());

        homepage.goToCard.click();

        String actualProductName = homepage.productInCart.getText();

        Assert.assertEquals(actualProductName,expectedProductName);

        homepage.deleteProductsInCart.click();

        homepage.allDelete.click();

        String expected = "Sepetin şu an boş";

        String actual = homepage.cardIsBlank.getText();

        Assert.assertEquals(actual,expected);

        WebElement element = Driver.getDriver().findElement(By.xpath("//div[@class='hb-toast-close-icon-holder']"));

        ReusableMethods.waitForClickablility(element,20);

        element.click();

        homepage.profileIcon.click();

        homepage.logoutIcon.click();

    }
}
