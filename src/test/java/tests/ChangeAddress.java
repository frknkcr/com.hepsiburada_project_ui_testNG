package tests;

import org.testng.annotations.Test;
import pages.Homepage;
import utilities.TestBaseRapor;

public class ChangeAddress extends TestBaseRapor {


    @Test
    public void test01(){

        Homepage homepage = new Homepage();

        homepage.login();

        homepage.homepageSelectLocation("antalya","kepez","emek");

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
