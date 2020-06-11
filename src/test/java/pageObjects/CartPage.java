package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='cart-icon']") 
	private WebElement btn_Cart;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'PROCEED TO CHECKOUT')]") 
	private WebElement btn_ProceedToCheckout;
	
	
	public void clickOn_Cart() {
		btn_Cart.click();
		System.out.println("Clicked on Cart Icon");
	}
	
	public void clickOn_ContinueToCheckout(){
		btn_ProceedToCheckout.click();
		System.out.println("Clicked on Proceed to Checkout button");
		try { Thread.sleep(5000);}
		catch (InterruptedException e) {}
	}
	
}