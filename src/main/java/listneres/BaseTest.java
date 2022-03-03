package listneres;

import com.sun.org.glassfish.gmbal.Description;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;



    public class BaseTest {


        public static WebDriver driver;

        @BeforeTest
        @Description("Before Test Method")
        public void beforeTest(){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setHeadless(true);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
            driver.manage().window().maximize();
        }

        @AfterTest
        @Description("After Test Method")
        public void closeBrowser(){
            driver.quit();
        }
    }


