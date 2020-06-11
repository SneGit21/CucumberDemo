package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import dataProviders.ConfigFileReader;
import managers.FileReaderManager;

public class HomePage {
	WebDriver driver;
	ConfigFileReader configFileReader;
		
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		configFileReader= new ConfigFileReader();
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search for Vegetables and Fruits']") 
	private WebElement txtbx_Search;
	
	@FindBy(how = How.XPATH, using = "//input[@class='quantity']")
	private WebElement txtbx_Quantity;
	
	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		System.out.println("Navigated to URL");
	}

	public void perform_Search(String search) {
		txtbx_Search.sendKeys(search);
		System.out.println("Searched for product : "+search);
	}
	
	public void enter_Quantity(String quantity) {
		txtbx_Quantity.clear();
		System.out.println("Cleared the quantity text field");
		txtbx_Quantity.sendKeys(quantity);
		System.out.println("Entered the quantity ["+quantity+"] in quantity field");
	}

}