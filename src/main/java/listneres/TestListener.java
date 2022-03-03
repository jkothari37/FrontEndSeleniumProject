package listneres;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


    public class TestListener extends BaseTest implements ITestListener {

        private static String getTestMethodName(ITestResult iTestResult){
            return iTestResult.getMethod().getConstructorOrMethod().getName();
        }

        @Attachment(value="Error Screenshot",type="image/png")
        public byte[] saveScreenshotPNG (WebDriver driver) {
            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        }

        @Attachment (value="{0}", type="text/plain")
        public static String saveTextLog(String message){
            return message;
        }
        @Override
        public void onTestFailure (ITestResult iTestResult){
            System.out.println("Inside onTestFailure Method " + getTestMethodName(iTestResult) + " failed");
            if(driver != null) {
                System.out.println("Screenshot Captured for test case: " + getTestMethodName(iTestResult));
                saveScreenshotPNG(driver);
            }
        }
    }

