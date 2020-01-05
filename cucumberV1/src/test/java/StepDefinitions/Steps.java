/**
 * 
 */
package StepDefinitions;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObjects.LoginPagePOM;
import Utilities.ObjectUltilities;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

/**
 * @author Debalina
 *
 */
public class Steps extends BaseClass {
	
	@Before
	public void setup() {
		System.out.println("=================SetUP================");
	}
	
	@After
	public void teardown() {
		System.out.println("=================Browser Close================");
	}
	
	@Before("@smoketest")
	public void beforeSmoke() {
		System.out.println("=================before SmokeTest================");
	}
	
	@After("@smoketest")
	public void afterSmoke() {
		System.out.println("=================After SmokeTest================");
	}
	

	@Given("^User Launch Chrome Browser$")
	public void user_Launch_Chrome_Browser() {
		System.setProperty("webdriver.chrome.driver", "E://Java//cucumberV1//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		lp = new LoginPagePOM(driver);
		ol = new ObjectUltilities(driver);
		log = Logger.getLogger(Steps.class);
		log.info("=========Launch a Browser=========");
	}

	@When("^User open nopcommerce url$")
	public void user_open_nopcommerce_url() {
		driver.get("https://admin-demo.nopcommerce.com/login");
		ol.pageLoad(20);
		log.info("=========Open nopcommerce application=========");
	}

	@When("^User open URL \"([^\"]*)\"$")
	public void user_open_URL(String url) {
		driver.get(url);
		log.info("=========Open nopcommerce application=========");
	}

	@And("^User enters register username and password$")
	public void user_enters_register_username_and_password() {
		lp.inputUserId("admin@yourstore.com");
		lp.inputPassword("admin");
		log.info("=========Provide Credentials=========");
	}

	@And("^User enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_Email_as_and_Password_as(String userName, String password) {
		lp.inputUserId(userName);
		lp.inputPassword(password);
		log.info("=========Provide Credentials=========");
	}

	@And("^User enters registerd username and password as a parameter$")
	public void user_enters_registerd_username_and_password_as_a_parameter(DataTable credentials) {
		List<List<String>> list = credentials.raw();
		lp.inputUserId(list.get(0).get(0));
		lp.inputPassword(list.get(0).get(1));
		log.info("=========Provide Credentials=========");
	}

	@And("^User enters registerd username and password as a parameter for multiple parameter testing$")
	public void user_enters_registerd_username_and_password_as_a_parameter_for_multiple_parameter_testing(
			DataTable credentials) {
		List<Map<String, String>> list = credentials.asMaps(String.class, String.class);
		lp.inputUserId(list.get(0).get("user"));
		lp.inputPassword(list.get(0).get("password"));
		log.info("=========Provide Credentials=========");
	}

	@When("^User enters registerd username and password as a parameter for multiple input$")
	public void user_enters_registerd_username_and_password_as_a_parameter_for_multiple_input(DataTable  credentials) {
		for (Map<String, String> list : credentials.asMaps(String.class, String.class)) {
			lp.inputUserId(list.get("user"));
			lp.inputPassword(list.get("password"));
		}
	}

	@When("^click on Login$")
	public void click_on_Login() {
		lp.submitBtn();
		log.info("=========Logout Application=========");
	}

	@Then("^Page Title should be \"([^\"]*)\"$")
	public void page_Title_should_be(String title) {
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
		log.info("=========Verify Page Title=========");
	}

	@When("^User click on Logout link$")
	public void user_click_on_Logout_link() throws InterruptedException {
		Thread.sleep(2);
		lp.logoutBtn();
	}

	@Then("^close browser$")
	public void close_browser() {
		driver.quit();
		log.info("=========Close a Browser=========");
	}

}
