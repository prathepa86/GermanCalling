package libraries;

import java.time.Duration;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import Base.BaseClass;

public class SeleniumWrapper extends BaseClass{
	
	
	public SeleniumWrapper(WebDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	
	public void type(WebElement ele,String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The data:"+data+"entered successfully into the field","PASS");
		}catch(InvalidElementStateException e) {
			reportStep("The data:"+data+"could not entered succesfully into the field","FAIL");
		}catch(WebDriverException e) {
			e.printStackTrace();
			reportStep("Unknown Exception occured while entering "+data+"into the data","FAIL");
		}
	}
	
	public void click(WebElement ele) {
		String text="";
		try {
			WebDriverWait oWait=new WebDriverWait(driver,Duration.ofSeconds(20));
			oWait.until(ExpectedConditions.elementToBeClickable(ele));
			text=ele.getText();
			ele.click();
			reportStep("The element"+text+"is clicked successfully","PASS");
		}catch(InvalidElementStateException e) {
			reportStep("The element"+text+"could not be clicked","FAIL");
		}catch(WebDriverException e) {
			reportStep("The unknown exception occured while clicking","FAIL");
		}
	}
	
	public boolean verifyDisplayedWithReturn(WebElement ele) {
		boolean Breturn=false;
		String attribute=ele.getAttribute("name");
		try {
			if(ele.isDisplayed()){
			reportStep("The element"+attribute+"is visible","PASS");
			Breturn=true;}
			else {
				reportStep("The element"+attribute+"is not visible","FAIL");
				
			}
			}catch(WebDriverException e) {
				reportStep("The element"+attribute+"is not visible","FAIL");
				
			}
		return Breturn;  
		}
	
	
	

}
