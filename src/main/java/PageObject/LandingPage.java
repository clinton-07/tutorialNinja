package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement MyAccountIcon;
	
	@FindBy(linkText = "Login")
	WebElement LoginOption;
	
	@FindBy(linkText= "Register")
	WebElement RegistrationOption;
	
	
	public WebElement LoginOption() {
		return LoginOption;
	}
	
	public WebElement MyAccountIcon() {
		return MyAccountIcon;
	}
	public WebElement RegistrationOption() {
		return RegistrationOption;
	}
	
	

}
