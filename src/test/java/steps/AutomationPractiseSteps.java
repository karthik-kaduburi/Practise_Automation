package steps;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.actions.AutomationPractise;
import utils.SeleniumDriver;

public class AutomationPractiseSteps {

	AutomationPractise automationPractiseActions = new AutomationPractise();

	@Given("^I am on the Home Page \"([^\"]*)\" of AutomationPractise Website$")
	public void i_am_on_the_Home_Page_of_AutomationPractise_Website(String webSiteURL) {
		SeleniumDriver.openPage(webSiteURL);

	}

	@Then("^I enter the \"([^\"]*)\" on \"([^\"]*)\"$")
	public void enterTheDetails(String details, String page, Map<String, String> map) {
		if (page.equalsIgnoreCase("AutomationPractise")) {
			automationPractiseActions.enterDetails(map);
		}
	}

	@Then("^verify the \"([^\"]*)\" displayed on \"([^\"]*)\"$")
	public void validateTheDetails(String details, String page, Map<String, String> map) {

		if (page.equalsIgnoreCase("AutomationPractise")) {
			automationPractiseActions.validateDetails(map);
		}
	}

	@When("^user enters \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void enterDetails(String text, String page) {
		if (page.equalsIgnoreCase("AutomationPractise")) {
			automationPractiseActions.enterDetails(text);
		}
	}

	@And("^clicked on \"([^\"]*)\" link$")
	public void click_on_link(String link) {

		automationPractiseActions.clickOnElement(link);
	}

	@And("^continue till payments$")
	public void continue_till_payments() {

		automationPractiseActions.continueTillPayments();
	}

	@And("^moved to \"([^\"]*)\" element$")
	public void move_to_element(String link) {

		automationPractiseActions.moveToElement(link);
	}

}
