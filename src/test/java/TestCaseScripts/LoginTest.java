package TestCaseScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.AccountPage;
import PageObject.LandingPage;
import PageObject.LoginPage;
import Resources.Base;

public class LoginTest extends Base{

	WebDriver driver;
	@Test(dataProvider="getLoginData")
	public void Login(String Email, String Password, String ExpectedResult) throws IOException, InterruptedException {
	
		LandingPage LP = new LandingPage(driver);
		LP.MyAccountIcon().click();
		LP.LoginOption().click();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.UserNameTextBox().sendKeys(Email);
		loginPage.PasswordTextBox().sendKeys(Password);
		loginPage.LoginButton().click();
		
		AccountPage AP = new AccountPage(driver);
		
		String actualResult;
		
		try {
			AP.EditYourAccountOption().isDisplayed();
			actualResult="Success";
			
		}catch(Exception e) {
			
			actualResult="Failure";
		
		}
		
		Assert.assertEquals(actualResult, ExpectedResult);
		
	}
	
	@BeforeMethod
	public void OpenApplication() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void QuitBrowser() {
		driver.quit();
		
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		Object [][] data = {{"clintoni2404@gmail.com", "Nick@123", "Success"},{"cli@gmail.com", "12345", "Failure"}};
		return data;
	}
}
