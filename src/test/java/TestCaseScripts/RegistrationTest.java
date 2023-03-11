package TestCaseScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import Resources.Base;

public class RegistrationTest extends Base{

	WebDriver driver;

	@Test
	public void register() throws InterruptedException {

		LandingPage LP = new LandingPage(driver);
		LP.MyAccountIcon().click();
		Thread.sleep(10000);
		LP.RegistrationOption().click();
		Thread.sleep(10000);

	}

	@BeforeMethod
	public void StartApplication() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}


}
