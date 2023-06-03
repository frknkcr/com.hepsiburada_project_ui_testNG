package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class CrossBrowserUrl {

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

        Driver.getDriver(browser).get(ConfigReader.getProperty("hepsiburadaUrl"));

        String expectedUrl = "https://www.hepsiburada.com/";

        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        Driver.closeDriver();

    }
}
