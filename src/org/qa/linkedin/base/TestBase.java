package org.qa.linkedin.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qa.linkedin.util.ListenerHelper;
import org.qa.linkedin.util.TestUtil;

public class TestBase {
public static WebDriver driver=null;
public static Properties prop=null;
public static WebDriverWait wait=null;

public TestBase() throws IOException {
	//create Object for Properties class
	prop=new Properties();
	//read the properties files
	FileInputStream fis=new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\org\\qa\\linkedin\\config\\config.properties"));
	//load the properties
	prop.load(fis);
}

public static void initilization() throws IOException {
	String browserName=prop.getProperty("browser");
	 if(browserName.equalsIgnoreCase("firefox")) {
			//set the geckodriver.exe path
				System.setProperty("webdriver.gecko.driver","D:\\BrowserExefiles\\geckodriver-v0.23.0-win64\\geckodriver.exe");
				//launch the browser
				//interface refvar=new implmentingclass();
			 driver=new FirefoxDriver();
		  }else if(browserName.equalsIgnoreCase("chrome")) {
			  System.setProperty("webdriver.chrome.driver", "D:\\BrowserExefiles\\chromedriver_win32\\chromedriver.exe");
				// launch the chrome browser
				 driver = new ChromeDriver();
		  }else if(browserName.equalsIgnoreCase("edge")) {
			// set the MicrosoftEdgeDriver.exe path
				System.setProperty("webdriver.edge.driver", "D:\\BrowserExefiles\\MicrosoftWebDriver.exe");
				// launch the edge browser
				 driver = new EdgeDriver();
		  }else if(browserName.equalsIgnoreCase("ie")) {
			// set IEDriverServer.exe file
				System.setProperty("webdriver.ie.driver", "D:\\BrowserExefiles\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
				//launch the IE browser
				driver=new InternetExplorerDriver();
		  }
		  
		// maximize the window
			driver.manage().window().maximize();
			// add implicit wait
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAIT, TimeUnit.SECONDS);
			//create Object for WebDriverWait class
		  wait =new WebDriverWait(driver,TestUtil.EXPLICITWAIT);
		  ListenerHelper listen = new ListenerHelper();
		  //create Object for EventFiringWebDriver class
		  EventFiringWebDriver browser = new EventFiringWebDriver(driver);
		  // Register the Listener onto EventFiringWebDriver object
		  browser.register(listen);
		  driver=browser;
		//open the linkedin.com
		driver.get(prop.getProperty("url"));
}
	
	
}
