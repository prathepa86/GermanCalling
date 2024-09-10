package Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import libraries.HTMLReport;
import util.ExcelReader;
import util.PropertyReader;

public class BaseClass extends HTMLReport{
	public WebDriver driver;
	public String fileName="environment";
	public String URL=PropertyReader.readDataFromPropertyFile(fileName, "sURL");
	public String browserType=PropertyReader.readDataFromPropertyFile(fileName, "browserType");
	public String testCaseName, testDesc,moduleName;
	public String excelFileName;
	@BeforeSuite
	public void reportInit() {
		startReport();
	}
	@AfterSuite 
	public void bindReport() {
		endReport();
	}
	
	@BeforeClass
	public void invokeBrowser() {
		switch(browserType.toLowerCase()) {
		case "chrome":
			System.out.println("The user option is :"+browserType+" . So,invoking chrome browser ");
		    driver=new ChromeDriver();
		    break;
		case "firefox":
			System.out.println("The user option is firefox"+browserType+".So,invoking the firefox browser");
		    driver=new FirefoxDriver();
		    break;
		case "edge":
			System.out.println("The user option is edge"+browserType+".So,invoking the firefox browser");
		    driver=new EdgeDriver();
		    break;
		    
		default:
			System.out.println("The user option is wrong:"+browserType+" . So,invoking the default chrome browser ");
		    driver=new ChromeDriver();
		    break;
		}
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		startTestCase(testCaseName,testDesc);
		startTestCase(moduleName);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	
	
	@DataProvider(name="ExcelData")
	public Object[][] gettingValuesFromExcel() {
		Object[][] values = ExcelReader.readDataFromExcel(excelFileName);
		return values;
	}
	
	@Override
	public String takeScreenShot() {
		String sPath=System.getProperty("user.dir")+"/snap/img"+System.currentTimeMillis()+".png";
		File dest=new File(sPath);
		TakesScreenshot oScreenshotAs=(TakesScreenshot)driver;
		File src = oScreenshotAs.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return sPath;
	}
	
	
	

}
