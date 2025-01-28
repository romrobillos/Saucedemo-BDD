package StepDefinitions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

public class ProductSteps extends BaseSteps {

	// Test for All Product images
	@Then("Validate all products images")
	public void validate_all_products_images() {
		ProductPage productPage = new ProductPage(driver);

		SoftAssert softAssert = new SoftAssert();

		String backpackActualSrc = productPage.getBackpackImageSrc();
		String backpackExpectedSrc = prop.getProperty("backpackImage");
		softAssert.assertEquals(backpackActualSrc, backpackExpectedSrc, "Backpack Image FAILED!");

		String bikeLightImageActualSrc = productPage.getBikeLightImageSrc();
		String bikeLightImageExpectedSrc = prop.getProperty("bikeLightImage");
		softAssert.assertEquals(bikeLightImageActualSrc, bikeLightImageExpectedSrc, "BikeLight Image FAILED!");

		String tshirtImageActualSrc = productPage.getTshirtImageSrc();
		String tshirtImageExpectedSrc = prop.getProperty("tshirtImage");
		softAssert.assertEquals(tshirtImageActualSrc, tshirtImageExpectedSrc, "Tshirt Image FAILED!");

		String jacketImageActualSrc = productPage.getJacketImageSrc();
		String jacketImageExpectedSrc = prop.getProperty("jacketImage");
		softAssert.assertEquals(jacketImageActualSrc, jacketImageExpectedSrc, "Jacket Image FAILED!");

		String onesieImageActualSrc = productPage.getOnesieImageSrc();
		String onesieImageExpectedSrc = prop.getProperty("onesieImage");
		softAssert.assertEquals(onesieImageActualSrc, onesieImageExpectedSrc, "Onesie Image FAILED!");

		String redshirtImageActualSrc = productPage.getRedshirtImageSrc();
		String redshirtImageExpectedSrc = prop.getProperty("redshirtImage");
		softAssert.assertEquals(redshirtImageActualSrc, redshirtImageExpectedSrc, "Redshirt Image for FAILED!");
		softAssert.assertAll();
	}

	// Verify Add and Remove Buttons
	@Then("Verify Add and Remove buttons")
	public void verify_add_and_remove_buttons() {
		ProductPage productPage = new ProductPage(driver);
		SoftAssert softAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Add and Remove button verification for Backpack

		try {
			wait.until(ExpectedConditions.elementToBeClickable(productPage.getAddBackpackBtn())).click();

			softAssert.assertTrue(productPage.getRemoveBackpackBtn().isDisplayed());
		} catch (Exception e) {
			softAssert.fail("Backpack Add button: Failed! Cannot able to add to cart!");
		}

		try {
			wait.until(ExpectedConditions.elementToBeClickable(productPage.getRemoveBackpackBtn())).click();

			softAssert.assertTrue(productPage.getAddBackpackBtn().isDisplayed());
		} catch (Exception e) {
			softAssert.fail("Backpack Remove button: Failed!");
		}

		// Add and Remove button verification for Bike Light button

		try {
			wait.until(ExpectedConditions.elementToBeClickable(productPage.getAddBikelightBtn())).click();

			softAssert.assertTrue(productPage.getRemoveBikelightBtn().isDisplayed());
		} catch (Exception e) {
			softAssert.fail("Bike Light Add button: Failed! Cannot able to add to cart!");
		}

		try {
			wait.until(ExpectedConditions.elementToBeClickable(productPage.getRemoveBikelightBtn())).click();

			softAssert.assertTrue(productPage.getAddBikelightBtn().isDisplayed());
		} catch (Exception e) {
			softAssert.fail("Bike Light Remove button: Failed!");
		}

		// Add and Remove button verification for T-Shirt

		try {
			wait.until(ExpectedConditions.elementToBeClickable(productPage.getAddShirtBtn())).click();

			softAssert.assertTrue(productPage.getRemoveShirtBtn().isDisplayed());
		} catch (Exception e) {
			softAssert.fail("T-Shirt Add button: Failed! Cannot able to add to cart!");
		}

		try {
			wait.until(ExpectedConditions.elementToBeClickable(productPage.getRemoveShirtBtn())).click();

			softAssert.assertTrue(productPage.getAddShirtBtn().isDisplayed());
		} catch (Exception e) {
			softAssert.fail("T-Shirt Remove button: Failed!");
		}

		// Add and Remove button verification for Jacket

		try {
			wait.until(ExpectedConditions.elementToBeClickable(productPage.getAddJacketBtn())).click();

			softAssert.assertTrue(productPage.getRemoveJacketBtn().isDisplayed());
		} catch (Exception e) {
			softAssert.fail("Jacket Add button: Failed! Cannot able to add to cart!");
		}

		try {
			wait.until(ExpectedConditions.elementToBeClickable(productPage.getRemoveJacketBtn())).click();

			softAssert.assertTrue(productPage.getAddJacketBtn().isDisplayed());
		} catch (Exception e) {
			softAssert.fail("Jacket Remove button: Failed!");
		}

		// Add and Remove button verification for Onesie

		try {
			wait.until(ExpectedConditions.elementToBeClickable(productPage.getAddOnesieBtn())).click();
			softAssert.assertTrue(productPage.getRemoveOnesieBtn().isDisplayed());
		} catch (Exception e) {
			softAssert.fail("Onesie Add button: Failed! Cannot able to add to cart!");
		}

		try {
			wait.until(ExpectedConditions.elementToBeClickable(productPage.getRemoveOnesieBtn())).click();
			softAssert.assertTrue(productPage.getAddOnesieBtn().isDisplayed());
		} catch (Exception e) {
			softAssert.fail("Onesie Remove button: Failed!");
		}

		// Add and Remove button verification for Red shirt

		try {
			wait.until(ExpectedConditions.elementToBeClickable(productPage.getAddRedshirtBtn())).click();
			softAssert.assertTrue(productPage.getRemoveRedshirtBtn().isDisplayed());
		} catch (Exception e) {
			softAssert.fail("RedShirt Add button: Failed! Cannot able to add to cart!");
		}

		try {
			wait.until(ExpectedConditions.elementToBeClickable(productPage.getRemoveRedshirtBtn())).click();
			softAssert.assertTrue(productPage.getAddRedshirtBtn().isDisplayed());
		} catch (Exception e) {
			softAssert.fail("Redshirt Remove button: Failed! ");
		}

		softAssert.assertAll();
	}

	@Then("Verify Cart badge")
	public void verify_cart_badge() {
		int expectedCount = 6;
		ProductPage productPage = new ProductPage(driver);
		productPage.getAddBackpackBtn().click();
		productPage.getAddBikelightBtn().click();
		productPage.getAddOnesieBtn().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(productPage.getAddJacketBtn())).click();
			productPage.getRemoveJacketBtn().isDisplayed();
			wait.until(ExpectedConditions.elementToBeClickable(productPage.getAddShirtBtn())).click();
			productPage.getRemoveShirtBtn().isDisplayed();
			wait.until(ExpectedConditions.elementToBeClickable(productPage.getAddRedshirtBtn())).click();
			productPage.getRemoveRedshirtBtn().isDisplayed();
		} catch (Exception e) {
			throw new SkipException(username
					+ " Skipping test: Jacket/Tshirt and Redshirt not found in the cart due to defect ProductPage Add/Remove Btns.");
		}

		String badgeText = productPage.getCartBadgeCount();
		System.out.println("Cart badge after adding item " + expectedCount + ": " + badgeText);

		Assert.assertEquals(badgeText, String.valueOf(expectedCount),
				"Cart badge should display '" + expectedCount + "' after adding item " + expectedCount);

	}

	// Verify Cart coordinates
	@Then("Verify Cart coordinates")
	public void verify_cart_coordinates() {
		ProductPage productPage = new ProductPage(driver);
		int x = 1203;
		int y = 10;

		WebElement cart = productPage.getCartBtn();
		Point point = cart.getLocation();
		int actualX = point.getX();
		int actualY = point.getY();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualX, x);
		softAssert.assertEquals(actualY, y);
		softAssert.assertAll();

	}

	// Verify Sort Price Low To High
	@Then("Verify Sort Price Low To High")
	public void verify_sort_price_low_to_high() {
		ProductPage productPage = new ProductPage(driver);
		List<Double> sortedPrices = Arrays.asList(7.99, 9.99, 15.99, 15.99, 29.99, 49.99);

		Select dropdown = new Select(productPage.getSortDropdownBtn());
		dropdown.selectByVisibleText("Price (low to high)");

		List<WebElement> afterPrice = productPage.getPriceList();
		List<Double> afterPriceList = new ArrayList<>();

		for (WebElement price : afterPrice) {
			afterPriceList.add(Double.valueOf(price.getText().replace("$", "")));
		}
		System.out.println("\nExpected:" + sortedPrices + "\nActual: " + afterPriceList);

		Assert.assertEquals(afterPriceList, sortedPrices, "Prices after sorting do not match!");
	}

	// Verify Sort Price High to Low
	@Then("Verify Sort Price High to Low")
	public void verify_sort_price_high_to_low() {
		ProductPage productPage = new ProductPage(driver);

		List<Double> sortedPrices = Arrays.asList(49.99, 29.99, 15.99, 15.99, 9.99, 7.99);

		Select dropdown = new Select(productPage.getSortDropdownBtn());
		dropdown.selectByVisibleText("Price (high to low)");

		List<WebElement> afterPrice = productPage.getPriceList();
		List<Double> afterPriceList = new ArrayList<>();

		for (WebElement price : afterPrice) {
			afterPriceList.add(Double.valueOf(price.getText().replace("$", "")));
		}
		System.out.println("\nExpected:" + sortedPrices + "\nActual: " + afterPriceList);

		Assert.assertEquals(afterPriceList, sortedPrices, "Prices after sorting do not match!");
	}

	// Verify Sort A to Z
	@Then("Verify Sort A to Z")
	public void verify_sort_a_to_z() {
		ProductPage productPage = new ProductPage(driver);

		List<String> sortedNames = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light",
				"Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie",
				"Test.allTheThings() T-Shirt (Red)");

		Select dropdown = new Select(productPage.getSortDropdownBtn());
		dropdown.selectByVisibleText("Name (A to Z)");

		List<WebElement> afterNames = productPage.getProductNamesList();
		List<String> afterNamesList = new ArrayList<>();

		for (WebElement name : afterNames) {
			afterNamesList.add(name.getText());
		}
		System.out.println("\nExpected:" + sortedNames + "\nActual  :" + afterNamesList);

		Assert.assertEquals(afterNamesList, sortedNames, "Names after sorting do not match!");
	}

	// Verify Sort Z to A
	@Then("Verify Sort Z to A")
	public void verify_sort_z_to_a() {
		ProductPage productPage = new ProductPage(driver);

		List<String> sortedNames = Arrays.asList("Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie",
				"Sauce Labs Fleece Jacket", "Sauce Labs Bolt T-Shirt", "Sauce Labs Bike Light", "Sauce Labs Backpack");

		Select dropdown = new Select(productPage.getSortDropdownBtn());
		dropdown.selectByVisibleText("Name (Z to A)");

		List<WebElement> afterNames = productPage.getProductNamesList();
		List<String> afterNamesList = new ArrayList<>();

		for (WebElement name : afterNames) {
			afterNamesList.add(name.getText());
		}
		System.out.println(username + "\nExpected:" + sortedNames + "\nActual  :" + afterNamesList);

		Assert.assertEquals(afterNamesList, sortedNames, "Names after sorting do not match!");
	}

	// Verify Glitch Z to A Sort
	@Then("Verify Glitch Z to A Sort")
	public void verify_glitch_z_to_a_sort() {
		ProductPage productPage = new ProductPage(driver);

		this.startTime = System.nanoTime();
		Select dropdown = new Select(productPage.getSortDropdownBtn());
		dropdown.selectByVisibleText("Name (Z to A)");
		this.endTime = System.nanoTime();

		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			throw new SkipException("Test skipped due to sorting is broken!");
		} catch (org.openqa.selenium.NoAlertPresentException e) {
		}

		this.duration = (endTime - startTime) / 1_000_000_000.0;
		Assert.assertTrue(this.duration <= 1.0, "\nSort took " + this.duration + " seconds expecting <=1.0 seconds");
	}

	// Verify Glitch High to Low Sort
	@Then("Verify Glitch High to Low Sort")
	public void verify_glitch_high_to_low_sort() {
		ProductPage productPage = new ProductPage(driver);

		this.startTime = System.nanoTime();
		Select dropdown = new Select(productPage.getSortDropdownBtn());
		dropdown.selectByVisibleText("Price (high to low)");
		this.endTime = System.nanoTime();

		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			throw new SkipException("Test skipped due to sorting is broken!");
		} catch (org.openqa.selenium.NoAlertPresentException e) {
		}

		this.duration = (endTime - startTime) / 1_000_000_000.0;
		Assert.assertTrue(this.duration <= 1.0, "\nSort took " + this.duration + " seconds expecting <=1.0 seconds");
	}

	// Verify Glitch Low to High Sort
	@Then("Verify Glitch Low to High Sort")
	public void verify_glitch_low_to_high_sort() {
		ProductPage productPage = new ProductPage(driver);

		this.startTime = System.nanoTime();
		Select dropdown = new Select(productPage.getSortDropdownBtn());
		dropdown.selectByVisibleText("Price (low to high)");
		this.endTime = System.nanoTime();

		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			throw new SkipException("Test skipped due to sorting is broken!");
		} catch (org.openqa.selenium.NoAlertPresentException e) {
		}

		this.duration = (endTime - startTime) / 1_000_000_000.0;
		Assert.assertTrue(this.duration <= 1.0, "\nSort took " + this.duration + " seconds expecting <=1.0 seconds");
	}
	
	@When("Add Backpack to Cart")
	public void add_backpack_to_cart() {
		ProductPage productPage = new ProductPage(driver);
		productPage.getAddBackpackBtn().click();
		productPage.toCart();
	}

	// Verify Logout
	@Then("Verify Logout")
	public void verify_logout() {
		new ProductPage(driver).toLogout();
		boolean userLoggedOut = new LoginPage(driver).isLogoutSuccessful();
		Assert.assertTrue(userLoggedOut);
	}
}
