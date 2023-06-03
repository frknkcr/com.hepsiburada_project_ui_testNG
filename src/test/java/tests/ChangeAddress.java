package tests;

import org.testng.annotations.Test;
import pages.Homepage;
import utilities.TestBaseRapor;

public class ChangeAddress extends TestBaseRapor {


    @Test
    public void test01(){

        extentTest = extentReports.createTest("user should be able to search by address on the home page");

        Homepage homepage = new Homepage();

        extentTest.info("user logs in with valid account information");
        homepage.login();
        extentTest.pass("logged in with valid information");

        extentTest.info("User should be able to choose the address information they want");
        homepage.homepageSelectLocation("antalya","kepez","emek");
        extentTest.pass("address information selected");

        extentTest.info("user logs out");
        homepage.homepageLogout();

        /*

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].removeAttribute('hidden');", homepage.selectBox);

        Select select = new Select(homepage.selectBox);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        select.selectByIndex(1);

        js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('hidden', '')", homepage.selectBox);

         */

    }
}
