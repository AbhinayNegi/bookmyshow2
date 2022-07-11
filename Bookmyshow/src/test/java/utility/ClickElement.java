package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Base_class;

public class ClickElement   {
	static WebDriver webdriver;
	
	public static  WebElement btnClick(WebElement e)  {
		webdriver = BrowserManager.getDriver();
	    WebDriverWait wait1=new WebDriverWait(webdriver,Duration.ofSeconds(10));
	    wait1.until(ExpectedConditions.elementToBeClickable(e)).click();
		return e;
	    
		
	   
}
	public static  void impicitwait() {
		webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
}

