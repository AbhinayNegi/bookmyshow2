package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import page.Home_page;



public class Base_class {

	protected static WebDriver webdriver;
	protected Properties config;
	protected String configFilename = "config";
	
	public static boolean invisiblePop = false;

	public String browser;
	public String url;
	

	public static Properties prop;
	public static Properties prop_loc = new Properties();

	


	@BeforeTest
	protected WebDriver initializebrowser() throws IOException {
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\Book_test\\Book_myshow");
			Properties prop = new Properties();
			prop.load(fis);
			url = prop.getProperty("url"); 
			browser = prop.getProperty("Browser");
			} 
				catch (IOException ex) {
			
						ex.printStackTrace();
						
				}

		if (browser.equalsIgnoreCase("Mozilla")) {
			

			webdriver = new FirefoxDriver();
			webdriver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("--start-maximized");
			webdriver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("edge")) {
			

			webdriver = new EdgeDriver();
			webdriver.manage().window().maximize();
		}
		return webdriver;

	}

}
