package sania.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 5;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true; 
        } else {
            System.out.println("Test failed after 5 retries. Possible reasons:");
            System.out.println(" Rush hours on Amazon. Try again later  Or check your internet connection.");
            System.out.println("Try again later or check your internet connection.");
            
            return false; 
        }
    }
}
