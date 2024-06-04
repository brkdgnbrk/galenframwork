package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage() {
        super();
    }

    @FindBy(css = "input[formcontrolname='userName']")
    private WebElement emailInput;

    @FindBy(css = "input[formcontrolname='password']")
    private WebElement passwordInput;

    @FindBy(css = "button.sign-in")
    private WebElement girisYapButton;

    @FindBy(id = "cbx-12")
    private WebElement beniHatırlaCheckbox;

    @FindBy(xpath = "//span[contains(text(),'Şifremi Unuttum')]")
    private WebElement sifremiUnuttumButton;

    @FindBy(css = "img.ng-tns-c170-1")
    private WebElement narposImage;

    @FindBy(css= ".swal2-x-mark")
    private WebElement errorMessageCrossImage;

    @FindBy(xpath= "//span[contains(text(),'Kullanıcı adı zorunludur')]")
    private WebElement errorMessageMail;

    @FindBy(css= "div[id='pn_id_2_content'] span[class='error-styles ng-star-inserted']")
    private WebElement errorMessagePassword;

    @FindBy(css= "div[id='pn_id_2_content'] i[class='fa-light fa-envelope icon']")
    private WebElement mailImage;

    @FindBy(css= ".welcome-text.ng-star-inserted")
    private WebElement sifreHatırlatmaControl;

    private void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isDisplayedErrorMessagePassword() {
        try {
            waitForElementToBeVisible(errorMessagePassword);
            return errorMessagePassword.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDisplayedErrorMessageMail() {
        try {
            waitForElementToBeVisible(errorMessageMail);
            return errorMessageMail.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean errorMessage() {
        try {
            waitForElementToBeVisible(errorMessageCrossImage);
            return errorMessageCrossImage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String errorMessageText() {
        return errorMessageCrossImage.getText();
    }
    public String sifreHatırlatmaControlText(){
        waitForElementToBeVisible(sifreHatırlatmaControl);
        return sifreHatırlatmaControl.getText();
    }

    public String errorMessageMail() {
        return errorMessageMail.getText();
    }

    public String errorMessagePassword() {
        return errorMessagePassword.getText();
    }

    public void loginInformation(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public void clickOnMailImageButton() {
        mailImage.click();
    }

    public void clickOnGirisYapButton() {
        girisYapButton.click();
    }

    public void isDisplayedNarposImage() {
        narposImage.isDisplayed();
    }

    public void clickOnSifremiUnuttumButton() {
        sifremiUnuttumButton.click();
    }

    public void clickOnBeniHatirlaCheckbox() {
        beniHatırlaCheckbox.click();
    }

    public boolean isBeniHatirlaCheckboxSelected() {
        return beniHatırlaCheckbox.isSelected();
    }
}
