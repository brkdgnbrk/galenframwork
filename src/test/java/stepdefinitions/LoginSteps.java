package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.BrowserUtils;
import utils.TestDataHelper;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps extends BaseStep {

	private static final Logger LOGGER = LogManager.getLogger(LoginSteps.class);


	@When("I enter valid email and password")
	public void i_enter_into_the_field() {
		Map<String, String> testData = TestDataHelper.readTestData("src/test/resources/testdata/Narpos Test Users");
		PAGES.getLoginPage().loginInformation(testData.get("validEmail"), testData.get("validPassword"));
	}

	@When("I click on the Giriş Yap button")
	public void i_click_on_the_button() {
		PAGES.getLoginPage().clickOnGirisYapButton();
		BrowserUtils.wait(1);
	}

	@Then("I should see the homepage")
	public void i_should_see_the_homepage() {
		PAGES.getLoginPage().isDisplayedNarposImage();
		BrowserUtils.wait(2);
	}

	@When("I enter email {string} and password {string}")
	public void iEnterEmailAndPassword(String email, String password) {
		Map<String, String> testData = TestDataHelper.readTestData("src/test/resources/testdata/Narpos Test Users");
		if (email.equals("validEmail")) {
			email = testData.get("validEmail");
		} else if (email.equals("invalidEmail")) {
			email = testData.get("invalidEmail");
		} else {
			email = "";
		}

		if (password.equals("validPassword")) {
			password = testData.get("validPassword");
		} else if (password.equals("invalidPassword")) {
			password = testData.get("invalidPassword");
		} else {
			password = "";
		}

		LOGGER.debug("Email and password read from Narpos Test Users file");
		PAGES.getLoginPage().loginInformation(email, password);
		if (password.isEmpty()) {
			PAGES.getLoginPage().clickOnMailImageButton();
		}

		LOGGER.debug("Username and password entered");
	}

	@Then("I should see an error message")
	public void iShouldSeeAnErrorMessage() {
		if (PAGES.getLoginPage().errorMessage()) {
			System.out.println("Error message displayed: " + PAGES.getLoginPage().errorMessageText());
		} else {
			System.out.println("Error message is not displayed.");
		}
	}

	@Then("I should see an error message for password or mail")
	public void iShouldSeeAnErrorMessageForPasswordOrMail() {
		if (PAGES.getLoginPage().isDisplayedErrorMessageMail()) {
			System.out.println("Error message displayed: " + PAGES.getLoginPage().errorMessageMail());
		} else if (PAGES.getLoginPage().isDisplayedErrorMessagePassword()) {
			System.out.println("Error message displayed: " + PAGES.getLoginPage().errorMessagePassword());
		} else {
			System.out.println("Error message is not displayed.");
		}
	}

	@When("I click on the Beni Hatırla checkbox")
	public void i_click_on_the_beni_hatirla_checkbox() {
		PAGES.getLoginPage().clickOnBeniHatirlaCheckbox();
	}

	@When("I refresh the page")
	public void i_refresh_the_page() {
		DRIVER.get("https://posbeta.narpos.com.tr/#/login");
		BrowserUtils.wait(2);
	}

	@Then("the Beni Hatırla checkbox should be selected")
	public void the_beni_hatirla_checkbox_should_be_selected() {
		assertThat(PAGES.getLoginPage().isBeniHatirlaCheckboxSelected()).isTrue();
	}
	@When("I click on the Şifremi Unuttum button")
	public void i_click_on_the_sifremi_unuttum_button() {
		PAGES.getLoginPage().clickOnSifremiUnuttumButton();
	}

	@Then("I should see the Şifre Hatırlatma text")
	public void i_should_see_the_sifre_hatirlatma_text() {
		assertThat(PAGES.getLoginPage().sifreHatırlatmaControlText()).isEqualTo("Şifre Hatırlatma");
	}
}
