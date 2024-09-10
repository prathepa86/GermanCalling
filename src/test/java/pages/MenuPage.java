package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import Base.BaseClass;
import libraries.SeleniumWrapper;

public class MenuPage extends BaseClass{
	
	
	protected  By dropDown= By.xpath("//a[@id='dropdownUser1']/span");
	protected By logoutBtn=By.xpath("//span/i");
	private WebDriver driver;
	private SeleniumWrapper oWrap;
	
	
	public MenuPage(WebDriver driver,ExtentTest node) {
		this.node=node;
		this.driver=driver;
		oWrap=new SeleniumWrapper(driver,node);
	}
	
	public MenuPage clickDropDown() {
		oWrap.click(driver.findElement(dropDown));
		return this;
	}
	
	public LoginPage clickLogOut() {
		oWrap.click(driver.findElement(logoutBtn));
		return new LoginPage(driver,node);
	}
	
	

}
