package utils;

import org.apache.commons.lang3.SystemUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver driver;

    
    public static WebDriver getDriver(){
    		
			String browserName = "firefox";
			if(browserName.equalsIgnoreCase("chrome")){
    	  	String chromedriverPath = "src/test/java/utils/drivers/chromedriver_windows_91.exe";
            System.setProperty("webdriver.chrome.driver", chromedriverPath);
            
              driver = new ChromeDriver();
              driver.manage().deleteAllCookies();
              driver.manage().window().maximize();
              Runtime.getRuntime().addShutdownHook(new Thread("Driver shutdown thread") {
                  public void run() {
                      driver.quit();
                      
                  }
              });
            }
            else if(browserName.equalsIgnoreCase("firefox")){
            String firefoxdriverPath = "src/test/java/utils/drivers/geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", firefoxdriverPath);
            
              driver = new FirefoxDriver();
              driver.manage().deleteAllCookies();
              driver.manage().window().maximize();
              Runtime.getRuntime().addShutdownHook(new Thread("Driver shutdown thread") {
                  public void run() {
                      driver.quit();
                      
                  }
              });
            }
            
       // } 
    else {
            System.out.println("************** OS Not supported **************");
        }



        return driver;
    }

	

	
}
