package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

public class testListeners extends extentReport implements ITestListener{
	
	private static ExtentReports extent;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Start the testcase");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("PASS");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("FAIL");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("SKIP");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Failed with the percentage");
		
	}

	@Override
	public void onStart(ITestContext context) {
		extent=setUp();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
