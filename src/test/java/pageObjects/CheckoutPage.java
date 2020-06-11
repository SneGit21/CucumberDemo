package pageObjects;


import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import managers.WebDriverManager;
import selenium.Wait;

public class CheckoutPage {
	
	public CheckoutPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//table[@class='cartTable']/tr") 
	private List<WebElement> productsTable;
	int noOfProducts = 0;
	public int noOfProductsInCheckOutPage()
	{
		int noOfProducts = (productsTable.size()-1);
		return noOfProducts;
	}
	
	@FindBy(how = How.XPATH, using = "//table[@class='cartTable']/tr[") 
	private WebElement productList1;
	
	@FindBy(how = How.XPATH, using = "]/td/p[@class='product-name']") 
	private WebElement productList2;
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter promo code']") 
	private WebElement txtbx_promoCode;
	
	@FindBy(how = How.XPATH, using = "//button[@class='promoBtn']") 
	private WebElement applyPromoCodeBtn;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Place Order')]") 
	private WebElement placeOrderBtn;
	
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='wrapperTwo']//div//select"))
	private WebElement country_List;	
	
	@FindBy(how = How.XPATH, using = "//input[@class='chkAgree']") 
	private WebElement chkbx_Agree;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Proceed')]") 
	private WebElement proceedBtn;
	
		
	public void fetchProductDetailsAtCheckout() {
		String p = Integer.toString(noOfProducts);
		String productDetail = productList1+p+productList2.getText();
	}
	
	public void enter_PromoCodeAndClickApply(String promocode) {
		txtbx_promoCode.sendKeys(promocode);
		System.out.println("Entered Promocode : "+promocode);
		applyPromoCodeBtn.click();
	}

	public void click_Proceed() {
		proceedBtn.click();
		System.out.println("Clicked on Proceed Button");
	}
	
	public void select_Country(String countryName) {
		country_List.click();
		System.out.println("Clicked on Country dropdown");
		try { Thread.sleep(2000);}
		catch (InterruptedException e) {}
		
		Select s = new Select(country_List);
		try{
		s.selectByVisibleText(countryName);
		System.out.println("Selected Country : "+countryName);}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Invalid Country Name !!!");
		}
	}
	
	public void check_TermsAndCondition(boolean value) {
		if(value) chkbx_Agree.click();
		System.out.println("Checked Agree to the Terms & Conditions checkbox");
	}
	
	public void clickOn_PlaceOrder() {
		placeOrderBtn.click();
		System.out.println("Clicked on Place Order button");
	}	
	

}