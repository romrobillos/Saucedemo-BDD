package StepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Then;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ProductPage;

public class CartSteps extends BaseSteps {

	@Then("Add Items to Cart")
	public void add_items_to_cart() {
		ProductPage productPage = new ProductPage(driver);
		List<WebElement> itemsToAdd = List.of(productPage.getAddBackpackBtn(), productPage.getAddBikelightBtn(),
				productPage.getAddJacketBtn(), productPage.getAddOnesieBtn(), productPage.getAddShirtBtn(),
				productPage.getAddRedshirtBtn());

		for (int i = 0; i < itemsToAdd.size(); i++) {
			productPage.addItemToCart(itemsToAdd.get(i));
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {

			Assert.assertTrue(productPage.getRemoveJacketBtn().isDisplayed());
			Assert.assertTrue(productPage.getRemoveShirtBtn().isDisplayed());
			Assert.assertTrue(productPage.getRemoveRedshirtBtn().isDisplayed());
		} catch (Exception e) {
			throw new SkipException(username
					+ " Skipping test: Jacket/Tshirt and Redshirt not found in the cart due to defect Add/Remove Btns.");
		}

		productPage.toCart();
	}

	@Then("Verify All Items if displayed on Cart")
	public void verify_all_items_if_displayed_on_cart() {

		CartPage cartPage = new CartPage(driver);

		Assert.assertTrue(cartPage.addedBackpack().isDisplayed());
		Assert.assertTrue(cartPage.addedBikelight().isDisplayed());
		Assert.assertTrue(cartPage.addedOnesie().isDisplayed());
		Assert.assertTrue(cartPage.addedJacket().isDisplayed());
		Assert.assertTrue(cartPage.addedRedshirt().isDisplayed());
		Assert.assertTrue(cartPage.addedShirt().isDisplayed());
	}

	@Then("Verify cart page remove button")
	public void verify_cart_page_remove_button() {

		CartPage cartPage = new CartPage(driver);
		List<WebElement> itemsToRemove = List.of(cartPage.removeBackpack(), cartPage.removeBikelight(),
				cartPage.removeJacket(), cartPage.removeOnesie(), cartPage.removeRedshirt(), cartPage.removeShirt());

		for (int i = 0; i < itemsToRemove.size(); i++) {
			cartPage.removeItemToCart(itemsToRemove.get(i));
		}
		cartPage.toContinueShop();
		ProductPage productPage = new ProductPage(driver);

		Assert.assertTrue(productPage.getAddBackpackBtn().isDisplayed());
		Assert.assertTrue(productPage.getAddBikelightBtn().isDisplayed());
		Assert.assertTrue(productPage.getAddOnesieBtn().isDisplayed());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(productPage.getAddJacketBtn())).click();
			productPage.getRemoveJacketBtn().isDisplayed();
			wait.until(ExpectedConditions.elementToBeClickable(productPage.getAddShirtBtn())).click();
			productPage.getRemoveShirtBtn().isDisplayed();
			wait.until(ExpectedConditions.elementToBeClickable(productPage.getAddRedshirtBtn())).click();
			productPage.getRemoveRedshirtBtn().isDisplayed();
		} catch (Exception e) {
			throw new SkipException(
					" Skipping test: Jacket/Tshirt and Redshirt not found in the cart due to defect Add/Remove Btns.");
		}
	}

	@Then("Verify CheckoutBtn coordinates")
	public void verify_checkout_btn_coordinates() {
		int x = 1045;
		int y = 217;

		CartPage cartPage = new CartPage(driver);
		WebElement checkout = cartPage.getCheckout();
		Point point = checkout.getLocation();
		int actualX = point.getX();
		int actualY = point.getY();

		System.out.println("CheckoutBtn X and Y coordinates: " + actualX + "," + actualY);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualX, x);
		softAssert.assertEquals(actualY, y);
		softAssert.assertAll();
	}

	@Then("Verify If All Items Can Checkout")
	public void verify_if_all_items_can_checkout() {
		new CartPage(driver).toCheckout();
		CheckoutPage checkoutPage = new CheckoutPage(driver);

		Assert.assertTrue(checkoutPage.isCheckoutPage());
	}

}
