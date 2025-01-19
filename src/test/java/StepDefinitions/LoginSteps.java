package StepDefinitions;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

public class LoginSteps {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;

	@Given("User launch browser")
	public void user_launch_browser() throws IOException {
		if (driver == null) {
			FileReader fr = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			prop.load(fr);
		}
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize();
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
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
		loginPage.inputCredentials(username, password);
	}

	@When("Click Login")
	public void click_login() {
		new LoginPage(driver).clickLogin();
	}

	@Then("Page Title should be on Product Page")
	public void page_title_should_be_on_product_page() {
		 new ProductPage(driver).isProductPageDisplayed();
	}

	@Then("Close the browser")
	public void close_the_browser() {
		driver.quit();
		System.out.println("Closed succesful");
	}
}
