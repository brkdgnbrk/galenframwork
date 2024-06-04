package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NarposHomePage extends BasePage {

    @FindBy(css = "body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)")
    private WebElement satışlarButton;

    @FindBy(css = "body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(10) > div:nth-child(1)")
    private WebElement masa11Button;

    @FindBy(xpath = "//span[contains(text(),'Lahana Çorbası')]")
    private WebElement lahanaÇorbasıButton;

    @FindBy(css = "div.scroll-product > div:nth-child(1) > div:nth-child(2)")
    private WebElement pazıYemeğiButton;

    @FindBy(xpath = "//button[contains(text(),'ÖDEME AL')]")
    private WebElement ödemeAlButton;

    // Düzeltme: 5 numarasına tıklama
    @FindBy(xpath = "//span[contains(text(),'50')]")
    private WebElement numberClick1;


    @FindBy(css = "div[class='col-12'] button[class='mat-focus-indicator button-font right-border-button button-left mat-button mat-button-base']")
    private WebElement iskontoButton;

    @FindBy(css = "#cbx-12")
    private WebElement yüzde50IskontoButton;

    @FindBy(css = ".p-ripple.p-element.p-button-raised.p-button-success.p-button.p-component")
    private WebElement kaydetButton;

    @FindBy(xpath= "//div[contains(text(),'Nakit')]")
    private WebElement nakitÖdemeButton;

    @FindBy(css = "div[class='col-xl-3 col-lg-3 col-md-12 col-sm-12'] button[class='mat-focus-indicator button-font button-left mat-button mat-button-base']")
    private WebElement tümüButton;

    @FindBy(css = "div[class='col-xl-3 col-lg-2 col-md-12 col-sm-12'] div:nth-child(2) span:nth-child(1) button:nth-child(1)")
    private WebElement kediKartıÖdemeButton;

    @FindBy(xpath = "//span[contains(text(),'MASA LİSTESİ')]")
    private WebElement masaListesiText;

    public void clickSatışlarButton() {
        satışlarButton.click();
    }

    public void clickMasa11Button() {
        masa11Button.click();
    }

    public void clickLahanaÇorbasıButton() {
        lahanaÇorbasıButton.click();
    }

    public void clickPazıYemeğiButton() {
        pazıYemeğiButton.click();
    }

    public void clickÖdemeAlButton() {
        ödemeAlButton.click();
    }

    public void clickNumberClick1() {
        numberClick1.click();
    }



    public void clickIskontoButton() {
        iskontoButton.click();
    }

    public void clickYüzde50IskontoButton() {
        yüzde50IskontoButton.click();
    }

    public void clickKaydetButton() {
        kaydetButton.click();
    }

    public void clickNakitÖdemeButton() {
        nakitÖdemeButton.click();
    }

    public void clickTümüButton() {
        tümüButton.click();
    }

    public void clickKediKartıÖdemeButton() {
        kediKartıÖdemeButton.click();
    }

    public boolean isMasaListesiTextDisplayed() {
        return masaListesiText.isDisplayed();
    }
}
