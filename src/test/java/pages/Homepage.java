package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Homepage {

    public Homepage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//div[@id='myAccount']")
    public WebElement homepageSignInButton;

    @FindBy (xpath = "//a[@id='login']")
    public WebElement signInButton;

    @FindBy (xpath = "//input[@id='txtUserName']")
    public WebElement usernameBox;


    @FindBy (xpath = "//input[@id='txtPassword']")
    public WebElement passwordBox;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy (xpath = "//*[@id='onetrust-accept-btn-handler']")
    public WebElement cookiePass;

    @FindBy (xpath = "//div[@data-test-id='campaign']")
    public WebElement firstProduct;

    @FindBy (xpath = "//div[@role='combobox']//input")
    public WebElement searchBox;

    @FindBy (xpath = "//h3[@data-test-id='product-card-name']")
    public WebElement productName;

    @FindBy (xpath = "//button[@id='addToCart']")
    public WebElement addToCard;

    @FindBy (xpath = "//span[@class='checkoutui-ProductOnBasketHeader-nOvp_U8bHbLzgKbSUFaz']")
    public WebElement productInCardPass;

    @FindBy (xpath = "//div[@class='checkoutui-SalesFrontCash-UqBFhChdjCX02lFgPVLK']//*[@type='button'][1]")
    public WebElement goToCard;

    @FindBy (xpath = "//div[@class='product_name_2Klj3']")
    public WebElement productInCart;

    @FindBy (xpath = "//div[@class='basket_delete_1U-UX']")
    public WebElement deleteProductsInCart;

    @FindBy (xpath = "//button[@class='sc-AxjAm jMVwZo']")
    public WebElement allDelete;

    @FindBy (xpath = "//div[@class='content_Z9h8v']//h1")
    public WebElement cardIsBlank;

    @FindBy (xpath = "//span[@class='sf-Account-OCDVU1XmkFmB514CAkR5']")
    public WebElement profileIcon;

    @FindBy (xpath = "//a[@class='sf-Account-zXNyGO4iZBebBK_uvVhs']")
    public WebElement logoutIcon;

    @FindBy (xpath = "//div[@data-test-id='dropdown-toggle']")
    public WebElement homepageChooseLocation;

    @FindBy (xpath = "//div[@data-test-id='dropdown-content']//button")
    public WebElement chooseNewLocation;

    @FindBy (xpath = "//select[@id='select-undefined']")
    public WebElement selectBox;

    @FindBy (xpath = "//div[@class='hb-toast-close-icon-holder']")
    public WebElement cardIsEmptyInfo;

    @FindBy (xpath = "(//a[@title='Kullanıcı Bilgilerim'])[1]")
    public WebElement myUserInformation;

    @FindBy (xpath = "//input[@id='txtName']")
    public WebElement myUserInformationNameTextBox;

    @FindBy (xpath = "//input[@id='genderMale']")
    public WebElement maleDropbox;

    @FindBy (xpath = "//input[@id='genderFemale']")
    public WebElement famaleDropbox;

    @FindBy (xpath = "(//button[text()='Güncelle'])[1]")
    public WebElement saveButton;

    @FindBy (xpath = "//div[@class='hb-toast-text']")
    public WebElement transactionNotification;

    @FindBy (xpath = "//a[text()='Şifre değişikliği']")
    public WebElement changePassword;

    @FindBy (xpath = "//input[@id='txtOldPassword']")
    public WebElement oldPassword;

    @FindBy (xpath = "//input[@id='txtNewPassword']")
    public WebElement newPassword;

    @FindBy (xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[3]/div/div[2]/div/div[2]")
    public WebElement passwordChangePassText;

    public void login(){

        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));

        ReusableMethods.hover(homepageSignInButton);

        signInButton.click();

        ReusableMethods.waitForVisibility(cookiePass,15);

        cookiePass.click();

        usernameBox.sendKeys(ConfigReader.getProperty("email"));

        submitButton.click();

        passwordBox.sendKeys(ConfigReader.getProperty("password"));

        submitButton.click();

    }

    public void homepageSelectLocation(String il, String ilce, String mahalle){

        homepageChooseLocation.click();

        chooseNewLocation.click();

        Driver.getDriver().findElement(By.xpath("(//div[@data-test-id='select-dropdown'])[1]")).click();

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(il).perform();

        Driver.getDriver().findElement(By.xpath("//div[@data-test-id='option-item']")).click();

        Driver.getDriver().findElement(By.xpath("(//div[@data-test-id='select-dropdown'])[2]")).click();

        actions.sendKeys(ilce).perform();

        Driver.getDriver().findElement(By.xpath("//div[@data-test-id='option-item']")).click();

        Driver.getDriver().findElement(By.xpath("(//div[@data-test-id='select-dropdown'])[3]")).click();

        actions.sendKeys(mahalle).perform();

        Driver.getDriver().findElement(By.xpath("//div[@data-test-id='option-item']")).click();

        Driver.getDriver().findElement(By.xpath("//*[@data-test-id='dropdown-content']//button")).click();

    }

    public void homepageLogout(){

        ReusableMethods.hover(homepageSignInButton);

        Driver.getDriver().findElement(By.xpath("//a[text()='Çıkış Yap']")).click();

    }

}
