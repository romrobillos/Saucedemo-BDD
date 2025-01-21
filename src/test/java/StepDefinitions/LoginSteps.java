package StepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

public class LoginSteps extends BaseSteps {

	@Given("User launch browser")
	public void user_launch_browser() throws IOException {
		setup();
	}

	@When("User open url saucedemo")
	public void user_open_url() {
		driver.get(prop.getProperty("testurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@When("User enter username as {string} and password as {string}")
	public void user_enter_user_as_and_password_as(String username, String password) {

		LoginPage loginPage = new LoginPage(driver);
		this.startTime = System.nanoTime();
		loginPage.inputCredentials(username, password);

	}

	@When("Click Login")
	public void click_login() {
		new LoginPage(driver).clickLogin();
		this.endTime = System.nanoTime();
	}

	@Then("Page Title should be on Product Page")
	public void page_title_should_be_on_product_page() {
		ProductPage productPage = new ProductPage(driver);
		Assert.assertTrue(productPage.isProductPageDisplayed());
	}

	@After
	@And("Close the browser")
	public void close_the_browser() {
		driver.quit();
	}

	// Response Time
	@Then("Login response time should be < 2 seconds")
	public void login_response_time_should_be_seconds() {
		this.duration = (endTime - startTime) / 1_000_000_000.0;
		Assert.assertTrue(this.duration <= 2.0, "\nLogin took " + this.duration + " seconds expecting <=2.0 seconds");
	}

	// Locked out error message
	@Then("Verify locked out error message")
	public void verify_locked_out_error_message() {
		LoginPage loginPage = new LoginPage(driver);
		this.errorMessage = loginPage.getErrorMessage();
		Assert.assertTrue(this.errorMessage.contains("Epic sadface: Sorry, this user has been locked out"));
	}

	// Invalid user error message
	@Then("Verify invalid user message")
	public void verify_invalid_user_message() {
		LoginPage loginPage = new LoginPage(driver);
		this.errorMessage = loginPage.getErrorMessage();
		Assert.assertTrue(this.errorMessage
				.contains("Epic sadface: Username and password do not match any user in this service"));
	}
}
