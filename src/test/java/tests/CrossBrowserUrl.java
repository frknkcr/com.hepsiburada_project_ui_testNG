package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class CrossBrowserUrl extends TestBaseRapor {

    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
                {"chrome"},
                {"firefox"},
                {"edge"}
        };
    }

    @Test(dataProvider = "testData")
    public void crossBrowseTest(String browser) {

        extentTest = extentReports.createTest("The user goes to the Hepsiburada.com homepage and the url is tested to be correct.");

        extentTest.info("page opens");
        Driver.getDriver(browser).get(ConfigReader.getProperty("hepsiburadaUrl"));

        String expectedUrl = "https://www.hepsiburada.com/";

        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("verified that the url of the visited page is www.hepsiburada.com with "+browser);

        Driver.closeDriver();

    }
}
