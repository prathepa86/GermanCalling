package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import libraries.SeleniumWrapper;



public class LoginPage extends MenuPage{
	
	private By userNameTxt=By.id("username");
	private By passwordTxt=By.id("password");
	private By loginBtn=By.xpath("//button[text()='Log In']");
	private WebDriver driver;
	private SeleniumWrapper oWrap;
	private By errorMsg=By.xpath("//li");
	private By forgotPassword=By.xpath("//a[text()='Forgot Password?']");
	



public LoginPage(WebDriver driver,ExtentTest node) {
	super(driver,node);
	this.node=node; 
	this.driver=driver;
	oWrap=new SeleniumWrapper(driver,node);
}

public boolean verifyLoginElements() {
	if(oWrap.verifyDisplayedWithReturn(driver.findElement(userNameTxt))&&
			oWrap.verifyDisplayedWithReturn(driver.findElement(passwordTxt))&&
			oWrap.verifyDisplayedWithReturn(driver.findElement(loginBtn))) {
		return true;
	}else {
		return false;
	}
}

public LoginPage enterUserName(String userName) {
	oWrap.type(driver.findElement(userNameTxt), userName);
	return this;
}

public LoginPage enterPassword(String Password) {
	oWrap.type(driver.findElement(passwordTxt), Password);
	return this;
}

public MenuPage clickLoginBtnWithValidCredentials() {
	oWrap.click(driver.findElement(loginBtn));
	return new MenuPage(driver,node);
}

public LoginPage clickLoginWithInvalidCredentials() {
	oWrap.click(driver.findElement(loginBtn));
	return this;
}

public ForgotPasswordPage clickOnForgotPasswordLink() {
	oWrap.click(driver.findElement(forgotPassword));
	return new ForgotPasswordPage(driver,node);
}


public boolean validateErrorMessage() {
	if(oWrap.verifyDisplayedWithReturn(driver.findElement(errorMsg))) {
		return true;
	}
	else {
		return false;
	}
}



}
