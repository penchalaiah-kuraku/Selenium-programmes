package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener

{	
	public void onStart(ITestContext Context) {
        System.out.println("Test Execution started.........");
    }
	
	public void onTestStart(ITestResult result) {
        System.out.println("Test Started.........");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed.........");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed........");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped......");
    }
}
