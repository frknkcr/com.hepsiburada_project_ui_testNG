package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Homepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class ChangeUserInfo {

    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void loginAndUserInfos(){

        Homepage homepage = new Homepage();

        homepage.login();

        ReusableMethods.wait(4);

        ReusableMethods.hover(homepage.homepageSignInButton);

        homepage.myUserInformation.click();

    }

    @Test (priority = 1)
    public void changeUserInfoTest(){

        Homepage homepage = new Homepage();

        Faker faker = new Faker();

        actions.moveToElement(homepage.myUserInformationNameTextBox).click()
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(faker.name().firstName()).perform();

        actions.sendKeys(Keys.TAB).sendKeys().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(faker.name().lastName()).perform();

        actions.sendKeys(Keys.TAB).sendKeys("12.01.1998").perform();

        if (!homepage.maleDropbox.isSelected()){
            homepage.maleDropbox.click();
        }

        ReusableMethods.wait(1);

        homepage.saveButton.click();

        ReusableMethods.waitForVisibility(homepage.transactionNotification,20);

        String expectedTransactionNotification = "Bilgileriniz başarıyla güncellendi.";

        String actualTransactionNotification = homepage.transactionNotification.getText();

        Assert.assertEquals(actualTransactionNotification,expectedTransactionNotification);

    }

    @Test (priority = 2)
    public void changePassword(){

        Homepage homepage = new Homepage();

        homepage.changePassword.click();

        ReusableMethods.wait(2);

        // Burada, sitenin sifre olusturma sartlarina uygun, yeni sifre oluşturan methodu cagiriyoruz
        String newPassword = ReusableMethods.hepsiburadaGeneratePassword();

        System.out.println("New Password: "+newPassword);

        actions.moveToElement(homepage.oldPassword).click()
                .sendKeys(ConfigReader.getProperty("password")).perform();

        actions.moveToElement(homepage.newPassword).click()
                .sendKeys(newPassword).perform();

        ReusableMethods.wait(2);

        homepage.saveButton.click();

        ReusableMethods.waitForVisibility(homepage.passwordChangePassText,20);

        // Burada olusabilecek aksiliklere karsi eski sifreyi confireader.properties dosyamiza kayit ediyoruz
        String oldPassword = ConfigReader.getProperty("password");

        System.out.println("Old Password: "+oldPassword);

        ConfigReader.setProperties("oldPassword",oldPassword);

        String actualactualTransactionNotification = homepage.passwordChangePassText.getText();

        String expectedTransactionNotification = "Şifreniz başarı ile değiştirildi";

        Assert.assertEquals(actualactualTransactionNotification,expectedTransactionNotification);

        System.out.println(actualactualTransactionNotification);

        // Burada yeni sifreyi confireader.properties dosyamiza kayit ediyoruz
        ConfigReader.setProperties("password",newPassword);

    }

    @AfterTest
    public void quit(){
        Driver.quitDriver();
    }
}
