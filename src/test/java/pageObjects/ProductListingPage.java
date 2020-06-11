package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductListingPage {
	
	public ProductListingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'ADD TO CART')]") 
	private WebElement btn_AddToCart;
	
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='products']/div"))
	private List<WebElement> prd_List;	
	
	@FindBy(how = How.XPATH, using = "//div[@class='product'][1]/h4")
	private WebElement productName;
	
	
	public void clickOn_AddToCart() {
		btn_AddToCart.click();
		System.out.println("Clicked on ADD TO CART button");
	}
	
	public void select_Product(int productNumber) {
		prd_List.get(productNumber).click();
		System.out.println("Selected ["+productNumber+"] th product");
	}

	public String getProductName() {
		return productName.getText();
	}
	
}