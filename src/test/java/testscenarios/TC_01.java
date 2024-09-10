package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseClass;
import pages.LoginPage;

public class TC_01 extends BaseClass{
	@BeforeTest
	public void setUp() {
		excelFileName="TC";
		authorName="Prathepa";
		category="Smoke";
		testCaseName="Login TestScenario";
		testDesc="Login Field Validation";
		moduleName="Login";
	}
	
	
	@Test(priority=1)
	public void loginFieldValidation() {
		boolean result=new LoginPage(driver,node)
				.verifyLoginElements();
		Assert.assertTrue(result);
	}
	
	@Test(priority=2,dataProvider ="ExcelData")
	public void loginWithValidCredentials(String UserName,String Password) {
		
		boolean result=new LoginPage(driver,node)
				.enterUserName(UserName)
				.enterPassword(Password)
				.clickLoginBtnWithValidCredentials()
				.clickDropDown()
				.clickLogOut()
				.verifyLoginElements();
		Assert.assertTrue(result);
		
	}
	
	@Test(priority=3)
	public void loginWithInvalidCredentials() {
		boolean result=new LoginPage(driver,node)
				.enterUserName("test123")
				.enterPassword("test@123")
				.clickLoginWithInvalidCredentials()
				.validateErrorMessage();
		Assert.assertTrue(result);
				
	}
	
	@Test(priority=4)
	public void loginWithInvalidPasswordProvidingSpaceInThePassword() {
		boolean result=new LoginPage(driver,node)
				.enterUserName("test@123")
				.enterPassword("test @123")
                .clickLoginWithInvalidCredentials()
                .validateErrorMessage();
		Assert.assertTrue(result);
		
	}
	
	@Test(priority=5)
	public void loginWithoutProvidingAnyValues() {
		boolean result=new LoginPage(driver,node)
				.enterUserName(" ")
				.enterPassword(" ")
				.clickLoginWithInvalidCredentials()
				.validateErrorMessage();
		Assert.assertTrue(result);
	}
	
	@Test(priority=6)
	public void clickOnTheForgotPasswordLink() {
		
	}
	
	
	

}
