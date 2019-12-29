/**
 * 
 */
package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.LoginPagePOM;
import cucumber.api.java.en.*;

/**
 * @author Debalina
 *
 */
public class Steps extends BaseClass {

	@Given("^User Launch Chrome Browser$")
	public void user_Launch_Chrome_Browser() {
		System.setProperty("webdriver.chrome.driver", "E://Java//cucumberV1//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		lp = new LoginPagePOM(driver);
	}

	@When("^User open nopcommerce url$")
	public void user_open_nopcommerce_url() {
		driver.get("https://admin-demo.nopcommerce.com/login");
	}

	@When("^User enters register username and password$")
	public void user_enters_register_username_and_password() {
		lp.inputUserId("admin@yourstore.com");
		lp.inputPassword("admin");
	}
	
	@When("^User open URL \"([^\"]*)\"$")
	public void user_open_URL(String url) {
	   driver.get(url);
	}

	@When("^User enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_Email_as_and_Password_as(String userName, String password) {
	    lp.inputUserId(userName);
	    lp.inputPassword(password);
	}

	@When("^click on Login$")
	public void click_on_Login() {
		lp.submitBtn();
	}

	@Then("^Page Title should be \"([^\"]*)\"$")
	public void page_Title_should_be(String title) {
    if(driver.getPageSource().contains("Login was unsuccessful.")) {
    	driver.close();
    	Assert.assertTrue(false);
    }
    else {
    	Assert.assertEquals(title, driver.getTitle());
    }
	}

	@When("^User click on Logout link$")
	public void user_click_on_Logout_link() {
     lp.logoutBtn();
	}

	@Then("^close browser$")
	public void close_browser() {
     driver.quit();
	}

}
