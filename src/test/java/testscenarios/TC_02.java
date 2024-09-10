package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseClass;
import pages.ForgotPasswordPage;


public class TC_02 extends BaseClass{
	
	@BeforeTest
	public void setUp() {
		excelFileName="TC2";
		testCaseName="ForgotPassword Test Scenario";
		testDesc="Forgot Password";
		moduleName="ForgotPassword";
		authorName="Prathepa";
		category="Smoke";
		
	}
	
	@Test(priority=1)
	public void verifyForgotPasswordPageElements() {
		boolean result=new ForgotPasswordPage(driver,node)
				.clickOnForgotPasswordLink()
				.verifyForgotPasswordPage();
		Assert.assertTrue(result);
				
	}
	
	//@Test(priority=2)
	public void clickOnResetLink() {
		boolean result=new ForgotPasswordPage(driver,node)
				.clickOnForgotPasswordLink()
				.enterEmailId("test@gmail.com")
				.clickOnResetLink()
				.clickOnBackToLoginBtn()
				.verifyLoginElements();
		Assert.assertTrue(result);
		
	}
	
	
	

}
