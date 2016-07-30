/**
 * This class provides common functionalities for other classes which do not require login credentials.
 * 
 * @author daisy
 */

package common;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class CommonCode {
	private String expectedTitle;

    protected static String IEWebDriverPath; 
	protected static String baseURL; 
	protected static WebDriver driver;
	protected static String ChromeWebDriverPath;

	@BeforeMethod
	@Parameters("browser")
	public void start(String browser) throws Exception {
		//Check if parameter passed from TestNG is 'firefox'

        if(browser.equalsIgnoreCase("firefox")){
        
        	//create firefox instance
        
        baseURL = utilities.Constants.baseURL;			
		driver = new FirefoxDriver();
			
	}
            
        //Check if parameter passed as 'chrome'

        else if(browser.equalsIgnoreCase("chrome")){
        	ChromeWebDriverPath = utilities.Constants.ChromeWebDriverPath;

   //set path to chromedriver.exe You may need to download it from http://code.google.com/p/selenium/wiki/ChromeDriver

            System.setProperty("webdriver.chrome.driver",ChromeWebDriverPath);

            //create chrome instance

            driver = new ChromeDriver();
        }
        
        else if(browser.equalsIgnoreCase("ie")){
        	IEWebDriverPath = utilities.Constants.IEWebDriverPath;

     //set path to IEdriver.exe You may need to download it from

     // 32 bits http://selenium-release.storage.googleapis.com/2.42/IEDriverServer_Win32_2.42.0.zip

     // 64 bits http://selenium-release.storage.googleapis.com/2.42/IEDriverServer_x64_2.42.0.zip

            System.setProperty("webdriver.ie.driver", IEWebDriverPath);

            //create chrome instance

            driver = new InternetExplorerDriver();

        }
        
        else{

            //If no browser passed throw exception

            throw new Exception("Browser is not found!");

        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
		expectedTitle = "Welcome !";
		driver.get(baseURL);
		driver.manage().window().maximize();
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@AfterMethod
	public void destroy() {
		driver.close();
	}
}