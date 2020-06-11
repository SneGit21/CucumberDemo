/*package stepDefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProviders.ConfigFileReader;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;

public class shoppingSteps {
	WebDriver driver;
	HomePage homePage;
	ProductListingPage productListingPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	PageObjectManager pageObjectManager;
	ConfigFileReader configFileReader;
	WebDriverManager webDriverManager;
	
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page(){
		//Opening Chrome Browser
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		
		//Maximizing the Chrome Browser
		driver.manage().window().maximize();
		
		//Setting 10 seconds of wait for every page load
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		
		//Navigate to Shopping Site
		pageObjectManager = new PageObjectManager(driver);
		homePage = pageObjectManager.getHomePage();
		homePage.navigateTo_HomePage();	
	}

	@When("^user search for \"([^\"]*)\"$")
	public void user_search_for(String product) throws Throwable {
		homePage.perform_Search(product);
	}

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() {
		productListingPage = pageObjectManager.getProductListingPage();
		productListingPage.clickOn_AddToCart();			
	}

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart(){
		cartPage = pageObjectManager.getCartPage();
		cartPage.clickOn_Cart();
		cartPage.clickOn_ContinueToCheckout();	
	}
	
	@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page() throws InterruptedException {
		checkoutPage = pageObjectManager.getCheckoutPage();
		checkoutPage.clickOn_PlaceOrder();
		checkoutPage.select_Country();	
	}

	@When("^place the order$")
	public void place_the_order() throws InterruptedException {
		checkoutPage.check_TermsAndCondition(true);
		checkoutPage.click_Proceed();		
	}	

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		webDriverManager.closeDriver();
	}
}*/