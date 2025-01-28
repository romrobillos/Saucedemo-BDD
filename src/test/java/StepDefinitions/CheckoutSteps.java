package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.*;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import utilities.CheckoutInfo;

public class CheckoutSteps extends BaseSteps {
	@When("To checkout")
	public void to_checkout() {
		new CartPage(driver).toCheckout();
	}
	
	
	@When("To Fill out information")
	public void to_fill_out_information() {
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		CheckoutInfo yourInfo = new CheckoutInfo();
		yourInfo.setFirstName("Jon Romeo");
		yourInfo.setLastName("Robillos");
		yourInfo.setZip("1008");
		checkoutPage.setInformation(yourInfo).toContinue();
 	 
	}

	@Then("Verify if checkout on all items is completed")
	public void verify_if_checkout_on_all_items_is_completed() {
		CheckoutPage checkoutPage = new CheckoutPage(driver).toFinish();
		Assert.assertTrue(checkoutPage.isCheckoutComplete());
	}
	
	@Then("Verify cancel button")
	public void verify_cancel_button() {
		new CheckoutPage(driver).toCancel();
		CartPage cartPage = new CartPage(driver);
		Assert.assertTrue(cartPage.getCheckout().isDisplayed());
	}
	
	@Then("Verify Response time of Cancel button")
	public void verify_response_time_of_cancel_button() {
		this.startTime = System.nanoTime();
		new CheckoutPage(driver).toCancel();
		this.endTime = System.nanoTime();
		
		this.duration = (endTime - startTime) / 1_000_000_000.0;
		Assert.assertTrue(this.duration <= 1.0, "\nCancel took " + this.duration + " seconds expecting <=1.0 seconds");
	}
	
	@Then("Verify finish button and Response time of Backhome button")
	public void verify_finish_button_and_response_time_of_backhome_button() {
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		try {
			WebElement finishBtn = wait.until(ExpectedConditions.visibilityOf(checkoutPage.getFinishBtn()));
			Assert.assertTrue(finishBtn.isDisplayed());
			checkoutPage.toFinish();
		} catch (Exception e) {
			throw new SkipException(username
					+ " Skipping test: Incomplete information due to defect txtbox! Unable to proceed.");
		}
		
		try {
			WebElement backhomeBtn = wait.until(ExpectedConditions.visibilityOf(checkoutPage.getBackhomeBtn()));
			Assert.assertTrue(backhomeBtn.isDisplayed());
			this.startTime = System.nanoTime();
			checkoutPage.toBackhomeBtn();
			this.endTime = System.nanoTime();
		} catch (Exception e) {
			Assert.fail("Test failed due to defect FinishBtn! Unable to proceed!.");
		}
 	
		this.duration = (endTime - startTime) / 1_000_000_000.0;
		Assert.assertTrue(this.duration <= 1.0, "\nBackhome took " + this.duration + " seconds expecting <=1.0 seconds");
	}
	
	@Then("Verify if Txtbox is working")
	public void verify_if_txtbox_is_working() {
		
		CheckoutInfo yourInfo = new CheckoutInfo();
		yourInfo.setFirstName("Jon Romeo");
		yourInfo.setLastName("Robillos");
		yourInfo.setZip("1008");
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.setInformation(yourInfo);
		String actualLastName = checkoutPage.getLastNameFieldValue();
		String actualFirstName = checkoutPage.getFirstNameFieldValue();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualFirstName, "Jon Romeo", "First Name does not match expected value!");
		softAssert.assertEquals(actualLastName, "Robillos", "Last Name does not match expected value!");
		softAssert.assertAll();
	}
	
	@Then("Verify error message when First Name is missing")
	public void verify_error_message_when_first_name_is_missing() {

		CheckoutPage checkoutPage = new CheckoutPage(driver);
		CheckoutInfo yourInfo = new CheckoutInfo();
		yourInfo.setFirstName("");
		yourInfo.setLastName("Robillos");
		yourInfo.setZip("1008");
		checkoutPage.setInformation(yourInfo).toContinue();
		this.errorMessage = checkoutPage.getErrorMessage();
		Assert.assertTrue(this.errorMessage.contains("Error: First Name is required"),
				"First Name Error message not found due to other textbox defect ");
	}
	
	@Then("Verify error message when Last Name is missing")
	public void verify_error_message_when_last_name_is_missing() {
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		CheckoutInfo yourInfo = new CheckoutInfo();
		yourInfo.setFirstName("Jon Romeo");
		yourInfo.setLastName("");
		yourInfo.setZip("1008");
		checkoutPage.setInformation(yourInfo).toContinue();
		try {
			boolean checkout = checkoutPage.isCheckoutPage();
			Assert.assertTrue(checkout);
			this.errorMessage = checkoutPage.getErrorMessage();
			Assert.assertTrue(this.errorMessage.contains("Error: Last Name is required"),
					"Error message do not match!");
		} catch (Exception e) {
			Assert.fail("Error Message not found! Checkout proceeded despite missing Last Name.");
		}
	}
	
}
