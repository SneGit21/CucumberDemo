package stepDefinition;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.HomePage;

public class HomePageSteps {
	
	TestContext testContext;
	HomePage homePage;
	
	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page(){
		homePage.navigateTo_HomePage();	
	}

	@When("^user search for \"([^\"]*)\"$")
	public void user_search_for(String product)  {
		homePage.perform_Search(product);
	}
	
	@When("^user selects quantity of product as \"([^\"]*)\"$")
	public void user_selects_quantity_of_product_as(String quantity)  {
		homePage.enter_Quantity(quantity);
	}

}