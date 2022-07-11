package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Base_class;
import utility.BrowserManager;

public class Home_page  {
	public static boolean invisiblePop = false;
	public static WebDriver webdriver;
	public static WebElement city_name;
	
	public static WebElement City_selection() {
		webdriver = BrowserManager.getDriver();
		WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofMillis(4000));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='sc-crNyjn dqNCYo']")));
		WebElement element1 = webdriver.findElement(By.xpath(("//img[@class='sc-crNyjn dqNCYo']")));
		return element1;

	}

	public static WebElement Sign_in() {
		webdriver = BrowserManager.getDriver();
		WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofMillis(4000));

		WebElement element1 = webdriver.findElement(By.xpath(("//div[text()='Sign in']")));
		return element1;
	}

	public static WebElement Entermob() {
		webdriver = BrowserManager.getDriver();

		WebElement element1 = webdriver.findElement(By.xpath(("//input[@id='mobileNo']")));
		return element1;

	}

	public static WebElement Continue_button() {
		webdriver = BrowserManager.getDriver();

		WebElement element1 = webdriver.findElement(By.xpath("//button[text()='Continue']"));
		return element1;

	}

	public static void Otp_popup() {
		webdriver = BrowserManager.getDriver();

		try {
			new WebDriverWait(webdriver, Duration.ofSeconds(20)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//form//div//div[text()='Verify your Mobile Number']")));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	public static WebElement select_city() {
		webdriver = BrowserManager.getDriver();
		city_name = webdriver.findElement(By.xpath("//img[@alt='NCR']"));
			return city_name;
			
		}
		
		public static WebElement sign_in () {
			webdriver = BrowserManager.getDriver();
			WebElement sign_in_Element = webdriver.findElement(By.xpath("//div[text()='Sign in']"));
			return sign_in_Element;
		}
		
		public static WebElement enter_mobile_number() {
			webdriver = BrowserManager.getDriver();
			WebElement mobile_number_field = webdriver.findElement(By.xpath("//input[@id='mobileNo']"));
			
			
			return mobile_number_field;
			
		}
		
		public static WebElement continue_login() {
			webdriver = BrowserManager.getDriver();
			WebElement continue_WebElement = webdriver.findElement(By.xpath("//button[text()='Continue']"));
			return continue_WebElement;
		}
		
		public static WebElement otp_verification() {
			return null;
			
		}

}
