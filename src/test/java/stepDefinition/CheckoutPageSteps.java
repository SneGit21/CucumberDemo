package stepDefinition;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import managers.PageObjectManager;
import pageObjects.CheckoutPage;
import testDataTypes.Product;

public class CheckoutPageSteps {
	TestContext testContext;
	CheckoutPage checkoutPage;
	
	public CheckoutPageSteps(TestContext context) {
		testContext = context;
		checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
	}
	
	@When("^select \"([^\"]*)\" on checkout page$")
	//@When("^select \\\"(.*)\\\" on checkout page$")
	public void select_on_checkout_page(String CountryName){
		checkoutPage.clickOn_PlaceOrder();		
		//Product product = FileReaderManager.getInstance().getJsonReader().getProductByName(CountryName);
		checkoutPage.select_Country(CountryName);
	
	}
	
	/*@When("^select same delivery address$")
	public void select_same_delivery_address(){
		checkoutPage.check_ShipToDifferentAddress(false);
	}
	
	@When("^select payment method as \"([^\"]*)\" payment$")
	public void select_payment_method_as_payment(String arg1){
		checkoutPage.select_PaymentMethod("CheckPayment");
	}
*/
	@When("^place the order$")
	public void place_the_order() {
		checkoutPage.check_TermsAndCondition(true);
		System.out.println("At Terms and conditions ........place order method");
		checkoutPage.click_Proceed();
		
	}	
	
	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		System.out.println("At close the browser method");
		testContext.getWebDriverManager().getReport();
		//testContext.getWebDriverManager().closeDriver();
	}

}