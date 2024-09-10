package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import libraries.SeleniumWrapper;

public class ForgotPasswordPage extends MenuPage{
	private WebDriver driver;
	private SeleniumWrapper oWrap;
	private By email=By.xpath("//input[@id='email']");
	private By forgotPassword=By.xpath("//a[text()='Forgot Password?']");
	private By resetLink=By.xpath("//button[text()='Send Reset Link']");
	private By BackTologin=By.linkText("Back to login");
	
	public ForgotPasswordPage(WebDriver driver,ExtentTest node) {
		super(driver,node);
		this.driver=driver;
		this.node=node;
		oWrap=new SeleniumWrapper(driver,node);
		
	}

public ForgotPasswordPage enterEmailId(String emailID) {
	oWrap.type(driver.findElement(email), emailID);
	return this;
}

public ForgotPasswordPage clickOnResetLink() {
	oWrap.click(driver.findElement(resetLink));
	return this;
}

public LoginPage clickOnBackToLoginBtn() {
	oWrap.click(driver.findElement(BackTologin));
	return new LoginPage(driver,node);
}
public ForgotPasswordPage clickOnForgotPasswordLink() {
	oWrap.click(driver.findElement(forgotPassword));
	return this;
}


public boolean verifyForgotPasswordPage() {
	if(oWrap.verifyDisplayedWithReturn(driver.findElement(email))&&
			oWrap.verifyDisplayedWithReturn(driver.findElement(resetLink))){
		return true;
	}else {
		return false;
	}
}


	

}
