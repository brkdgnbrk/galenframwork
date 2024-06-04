package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BrowserUtils;

public class MasaİşlemeriSteps extends BaseStep {

    @When("I click on the SATIŞLAR button")
    public void iClickOnTheSATISLARButton() {
        PAGES.getNarposHomePage().clickSatışlarButton();

    }

    @And("I click on the Masa 11 button")
    public void iClickOnTheMasaButton() {
        PAGES.getNarposHomePage().clickMasa11Button();
        BrowserUtils.wait(2);
    }

    @And("I enter the Lahana Çorbası")
    public void iEnterTheLahanaCorbası() {
        PAGES.getNarposHomePage().clickLahanaÇorbasıButton();
    }

    @And("I enter the Pazı Yemeği")
    public void iEnterThePazıYemegi() {
        PAGES.getNarposHomePage().clickPazıYemeğiButton();
    }

    @And("I click on the ÖDEME AL button")
    public void iClickOnTheODEMEALButton() {
        PAGES.getNarposHomePage().clickÖdemeAlButton();
    }

    @And("I enter İskonto 50 TL")
    public void iEnterIskontoTL() {
        PAGES.getNarposHomePage().clickNumberClick1();
        BrowserUtils.wait(2);
        PAGES.getNarposHomePage().clickIskontoButton();
        BrowserUtils.wait(2);
        PAGES.getNarposHomePage().clickYüzde50IskontoButton();
    }


    @And("I click on the Kaydet button")
    public void iClickOnTheKaydetButton() {
        BrowserUtils.wait(2);
        PAGES.getNarposHomePage().clickKaydetButton();
    }

    @And("I pay 50 Tl in cash")
    public void iPayTlInCash() {
        BrowserUtils.wait(2);
        PAGES.getNarposHomePage().clickNumberClick1();
        BrowserUtils.wait(2);
        PAGES.getNarposHomePage().clickNakitÖdemeButton();
    }

    @And("I pay the remaining amount by credit card")
    public void iPayTheRemainingAmountByCreditCard() {
        PAGES.getNarposHomePage().clickTümüButton();
        PAGES.getNarposHomePage().clickKediKartıÖdemeButton();
    }

    @Then("I should see the table payment confirmation")
    public void iShouldSeeTheTablePaymentConfirmation() {
        PAGES.getNarposHomePage().isMasaListesiTextDisplayed();
    }
}
