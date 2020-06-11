package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	private static WebDriver driver;
	
	@Given("^User is on E-commerce demo page$")
	public void user_is_on_E_commerce_demo_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//Set Properties for Chrome Browser
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/lib/chromedriver_win32/chromedriver.exe");
				
				//Opening Chrome Browser
				driver = new ChromeDriver();
				
				//Maximizing the Chrome Browser
				driver.manage().window().maximize();
				
				//Setting 10 seconds of wait for every page load
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//Hitting the URL
				driver.get("https://rahulshettyacademy.com/angularpractice/");
				System.out.println("Successfully navigated to Automaton Demo URL");
	}

	@When("^User enters all the correct values in al the fields and clicks on submit button$")
	public void user_enters_all_the_correct_values_in_al_the_fields_and_clicks_on_submit_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//Enter all the form details and submit the form
				WebElement name = driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']"));
				name.sendKeys("Test M");
				System.out.println("Entered Name");
				
				WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
				email.sendKeys("test@abc.in");
				System.out.println("Entered Email Address");
				
				WebElement password = driver.findElement(By.xpath("//input[@id='exampleInputPassword1']"));
				password.sendKeys("test@123");
				System.out.println("Entered Password");
				
				WebElement IceCreamcheckbox	= driver.findElement(By.xpath("//input[@id='exampleCheck1']"));
				IceCreamcheckbox.click();
				System.out.println("Clicked on IceCreamcheckbox");
				
				WebElement gender = driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));
				Select s = new Select(gender);
				s.selectByVisibleText("Female");
				System.out.println("Selected Female as Gender");
				
				String employment = "Employed";
				WebElement employmentStatus = driver.findElement(By.xpath("//label[contains(text(),'Employment Status')]/../div/label[contains(text(),'"+employment+"')]/../input"));
				employmentStatus.click();
				System.out.println("Selected Employed as "+employment+" Status");
				
				String dateOfBirth = "06212001";
				WebElement dob = driver.findElement(By.xpath("//input[@name='bday']"));
				dob.sendKeys(dateOfBirth);
				System.out.println("Entered Date of Birth : "+dateOfBirth);
				
				WebElement submitBtn = driver.findElement(By.xpath("//input[@class='btn btn-success']"));
				submitBtn.click();
				System.out.println("Clicked on Submit button");
	}

	@Then("^Form should be submitted successfully$")
	public void form_should_be_submitted_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement successMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/strong"));
		String ActualSuccessMsg = successMsg.getText();
		System.out.println("Actual Success Msg : "+ActualSuccessMsg);
		
		String ExpectedSuccessMsg = "Success!";
		if(ExpectedSuccessMsg.equalsIgnoreCase(ActualSuccessMsg))
		{
			System.out.println("The form is submitted successfully");
		}
		else
		{
			System.out.println("Failed to submit the form");
		}
	}

	@Then("^quit the browser$")
	public void quit_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
	}


}
