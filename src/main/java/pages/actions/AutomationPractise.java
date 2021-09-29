package pages.actions;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.SeleniumDriver;

/**
 * @author karthik kaduburi
 *
 */
public class AutomationPractise {


	public By signIn = By.xpath("//a[@title='Log in to your customer account']");
	public By email = By.xpath("//input[@id='email_create']");
	public By createAcc = By.xpath("//button[@id='SubmitCreate']/span");
	public By title = By.xpath("//input[@id='id_gender1']");
	public By fName = By.xpath("//input[@id='customer_firstname']");
	public By lName = By.xpath("//input[@id='customer_lastname']");
	public By passWord = By.xpath("//input[@id='passwd']");
	public By dayDDown = By.xpath("//Select[@id='days']");
	public By monthDDown = By.xpath("//Select[@id='months']");
	public By yearDDown = By.xpath("//Select[@id='years']");
	public By Addr_fName = By.xpath("//input[@id='firstname']");
	public By Addr_lName = By.xpath("//input[@id='lastname']");
	public By Addr_company = By.xpath("//input[@id='company']");
	public By Addr_1 = By.xpath("//input[@id='address1']");
	public By Addr_2 = By.xpath("//input[@id='address2']");
	public By Addr_city = By.xpath("//input[@id='city']");
	public By Addr_stateDDown = By.xpath("//Select[@id='id_state']");
	public By Addr_postalCode = By.xpath("//input[@id='postcode']");
	public By Addr_mobile = By.xpath("//input[@id='phone_mobile']");
	public By register = By.xpath("//button[@id='submitAccount']/span");
	public By signOut = By.xpath("//a[@title='Log me out']");
	public By userName = By.xpath("//input[@id='email']");
	public By password = By.xpath("//input[@id='passwd']");
	public By logIn = By.xpath("//button[@id='SubmitLogin']/span");
	public By tShirts = By.xpath("//div[@id='block_top_menu']/ul/li/a[@title='T-shirts']");
	public By addToCart = By.xpath("//a[@title='Add to cart']");
	public By proceedToCheckOut = By.xpath("//span[contains(text(),'Proceed')]");
	public By signInCheckout = By.xpath("//*[@id='center_column']/p[2]/a[1]/span");
	public By addressCheckout = By.xpath("//*[@id='center_column']/form/p/button/span");
	public By shippingCheckout = By.xpath("//*[@id='form']/p/button/span");
	public By agreeTerms = By.xpath("//*[contains(text(),'I agree')]");
	public By paymentTshirt = By.xpath("//*[contains(text(),'Des')]/following::*[contains(text(),'T-shirts')][1]");
	JavascriptExecutor js = (JavascriptExecutor) SeleniumDriver.getDriver();



	/**
	 * @param signIn 
	 * Clicks On Button/link
	 */
	public void clickOnElement(String link) {
		if (link.equalsIgnoreCase("Sign in")) {
			SeleniumDriver.getDriver().findElement(signIn).click();
		} else if (link.equalsIgnoreCase("Register")) {
			SeleniumDriver.getDriver().findElement(register).click();
		} else if (link.equalsIgnoreCase("Sign out")) {
			SeleniumDriver.getDriver().findElement(signOut).click();
		} else if (link.equalsIgnoreCase("create an account")) {
			SeleniumDriver.getDriver().findElement(createAcc).click();
		} else if (link.equalsIgnoreCase("Log in")) {
			SeleniumDriver.getDriver().findElement(logIn).click();
		} else if (link.equalsIgnoreCase("T-Shirts")) {
			SeleniumDriver.getDriver().findElement(tShirts).click();
			SeleniumDriver.waitForPageToLoad();
		} else if (link.equalsIgnoreCase("add to cart")) {
			js.executeScript("arguments[0].click();", SeleniumDriver.getDriver().findElement(addToCart));
			SeleniumDriver.waitForSeconds(2);
		} else if (link.equalsIgnoreCase("proceed to checkout")) {
			SeleniumDriver.getDriver().findElement(proceedToCheckOut).click();
		}
	}

	/**
	 * @param link
	 * move to element
	 * click on the button
	 */
	public void moveToElement(String link) {

		js.executeScript("arguments[0].scrollIntoView(true);",
				SeleniumDriver.getDriver().findElement(By.xpath("//*[@class='product-image-container']")));
		Actions action = new Actions(SeleniumDriver.getDriver());
		action.moveToElement(SeleniumDriver.getDriver().findElement(By.xpath("//*[@class='product-image-container']")))
				.perform();
	}

	/**
	 * @param text 
	 * Enter Details in form fields
	 */
	public void enterDetails(String text) {
		// TODO Auto-generated method stub
		SeleniumDriver.getDriver().findElement(email).sendKeys(text);
	}

	/**
	 * @param map 
	 * Enter the Personal Info Details
	 */
	public void enterDetails(Map<String, String> map) {
		// TODO Auto-generated method stub
		if (map.containsKey("Title")) {
			SeleniumDriver.getDriver().findElement(title).sendKeys(map.get("Title"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("firstName")) {
			SeleniumDriver.getDriver().findElement(fName).sendKeys(map.get("firstName"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("lastName")) {
			SeleniumDriver.getDriver().findElement(lName).sendKeys(map.get("lastName"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("password")) {
			SeleniumDriver.getDriver().findElement(passWord).sendKeys(map.get("password"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("dob")) {
			String[] dob = map.get("dob").split("/");
			String day = dob[0];
			String month = dob[1];
			String year = dob[2];
			SeleniumDriver.getDriver().findElement(dayDDown).click();
			SeleniumDriver.getDriver()
					.findElement(
							By.xpath("//Select[@id='days']/option/following-sibling::option[@value='" + day + "']"))
					.click();
			SeleniumDriver.waitForSeconds(1);
			SeleniumDriver.getDriver().findElement(monthDDown).click();
			SeleniumDriver.getDriver()
					.findElement(
							By.xpath("//Select[@id='months']/option/following-sibling::option[@value='" + month + "']"))
					.click();
			SeleniumDriver.waitForSeconds(1);
			SeleniumDriver.getDriver().findElement(yearDDown).click();
			SeleniumDriver.getDriver()
					.findElement(
							By.xpath("//Select[@id='years']/option/following-sibling::option[@value='" + year + "']"))
					.click();
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("fName")) {
			SeleniumDriver.getDriver().findElement(Addr_fName).sendKeys(map.get("fName"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("lName")) {
			SeleniumDriver.getDriver().findElement(Addr_lName).sendKeys(map.get("lName"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("company")) {
			SeleniumDriver.getDriver().findElement(Addr_company).sendKeys(map.get("company"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("address1")) {
			SeleniumDriver.getDriver().findElement(Addr_1).sendKeys(map.get("address1"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("address2")) {
			SeleniumDriver.getDriver().findElement(Addr_2).sendKeys(map.get("address2"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("city")) {
			SeleniumDriver.getDriver().findElement(Addr_city).sendKeys(map.get("city"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("state")) {
			SeleniumDriver.getDriver().findElement(Addr_stateDDown).click();
			SeleniumDriver.getDriver().findElement(By.xpath("//option[text()='Alabama']")).click();
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("postalCode")) {
			SeleniumDriver.getDriver().findElement(Addr_postalCode).sendKeys(map.get("postalCode"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("mobileNo")) {
			SeleniumDriver.getDriver().findElement(Addr_mobile).sendKeys(map.get("mobileNo"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("userName")) {
			SeleniumDriver.getDriver().findElement(userName).sendKeys(map.get("userName"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("pass")) {
			SeleniumDriver.getDriver().findElement(password).sendKeys(map.get("pass"));
			SeleniumDriver.waitForSeconds(1);
		}
	}

	/**
	 * @param map
	 * Validate details on a page
	 */
	public void validateDetails(Map<String, String> map) {
		// TODO Auto-generated method stub
		if (map.containsKey("firstName")) {
			try {
				String name = map.get("firstName") + " " + map.get("lastName");
				Assert.assertTrue(SeleniumDriver.getDriver().findElement(By.xpath("//span[text()='" + name + "']"))
						.isDisplayed());

			} catch (NoSuchElementException e) {
				Assert.fail("First Name and Last Name is not displayed");
			}
		} else if (map.containsKey("product")) {
			try {
				Assert.assertTrue(SeleniumDriver.getDriver().findElement(paymentTshirt).isDisplayed());

			} catch (NoSuchElementException e) {
				Assert.fail("Product Details are not valid");
			}
		}

	}

	/**
	 * Navigate till Payments page
	 */
	public void continueTillPayments() {
		// TODO Auto-generated method stub
		SeleniumDriver.getDriver().findElement(signInCheckout).click();
		;
		SeleniumDriver.waitForSeconds(1);
		SeleniumDriver.getDriver().findElement(addressCheckout).click();
		;
		SeleniumDriver.waitForSeconds(1);
		SeleniumDriver.getDriver().findElement(agreeTerms).click();
		SeleniumDriver.waitForSeconds(1);
		SeleniumDriver.getDriver().findElement(shippingCheckout).click();
		SeleniumDriver.waitForSeconds(1);

	}

}
