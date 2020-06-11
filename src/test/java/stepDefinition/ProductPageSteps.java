package stepDefinition;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import enums.Context;
import pageObjects.ProductListingPage;

public class ProductPageSteps {
	
	TestContext testContext;
	ProductListingPage productListingPage;
	
	public ProductPageSteps(TestContext context) {
		testContext = context;
		productListingPage = testContext.getPageObjectManager().getProductListingPage();
	}

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() {
		//productListingPage.select_Product(0);
		//testContext.getScenarioContext().setContext(Context.PRODUCT_NAME, productListingPage.getProductName());
		productListingPage.clickOn_AddToCart();	
		
	}
}