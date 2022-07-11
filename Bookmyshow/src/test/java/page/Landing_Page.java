package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Base_class;
import utility.BrowserManager;

public class Landing_Page {

	static WebDriver webdriver;
	
	public static WebElement List_Your_Show() {
		webdriver = BrowserManager.getDriver();
		WebElement element1 =webdriver.findElement(By.xpath(("//a[@href='/list-your-show']")));
		return element1;
		
	  }
	public static WebElement List_Btn() {
		webdriver = BrowserManager.getDriver();
	WebElement element1 =webdriver.findElement(By.xpath(("(//button[@class='sc-1y2oebh-1 iRpfzT   'and @type='default'])[1]")));
   return element1;

	
	}
	public static WebElement List_Popup_Btn() {
		webdriver = BrowserManager.getDriver();
		WebElement element1 =webdriver.findElement(By.xpath(("//div[contains(@class,'sc-7silkt-1 kTfyez')]//p[contains(@class,'sc-1pz8rb6-1 ebjpiw')][normalize-space()='List your show']")));
	   return element1;
}
}