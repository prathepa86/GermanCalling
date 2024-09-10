package libraries;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class HTMLReport {
	public static ExtentSparkReporter oSpark;
	public static ExtentReports oReport;
	public  ExtentTest test,node;
	public String authorName,category;
	
	public void startReport() {
		oSpark=new ExtentSparkReporter("./reports/GermanCallingReport.html");
		oReport=new ExtentReports();
		oReport.attachReporter(oSpark);
	}
	
	public void endReport() {
		oReport.flush();
	}
	
	public ExtentTest startTestCase(String testCaseName,String testDesc) {
		test=oReport.createTest(testCaseName,testDesc);
		test.assignAuthor(authorName);
		test.assignCategory(category);
		return test;
		
	}
	
	public ExtentTest startTestCase(String nodes) {
		node = test.createNode(nodes);
		return node;
	}
	
	public void reportStep(String desc,String status) {
		if(status.equalsIgnoreCase("pass")) {
			node.pass(desc,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
		}else if(status.equalsIgnoreCase("fail")) {
			node.fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
		
		}else {
			node.info(desc);
		}
	}
	
	public abstract String takeScreenShot();
	
	
	

}
