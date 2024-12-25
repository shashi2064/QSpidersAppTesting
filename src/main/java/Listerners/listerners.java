package Listerners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClass.BaseClass;

public class listerners implements ITestListener, ISuiteListener {

	public WebDriver driver;

	@Override
	public void onStart(ISuite suite) {
		Reporter.log("Suite configuration started", true);

		// Configure reports
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvancedReports/LLReports.html");

		spark.config().setReportName("CreateContact");

		spark.config().setDocumentTitle("VtigerReport");

		spark.config().setTheme(Theme.STANDARD);

		// Add configuration for Reports
		ExtentReports report = new ExtentReports();

		report.attachReporter(spark);

		report.setSystemInfo("OS", "Windows 11");

		report.setSystemInfo("Browser", "131");

		// Creating test
		ExtentTest test = report.createTest("CreateContactTest");
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("Suite configuration Finished", true);
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		Reporter.log(testname + "Test started", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		Reporter.log(testname + "Test success", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		Reporter.log(testname + "Test Failure", true);

		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		File dst = new File("./screenshot" + testname + "ss.png");

		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		Reporter.log(testname + "Test Skipped", true);
	}

}
