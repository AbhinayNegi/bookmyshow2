package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Click_WebElements {
	static WebDriver webdriver;
	public static  WebElement btnClick(WebElement e)  {
		webdriver = BrowserManager.getDriver();
	    WebDriverWait wait2=new WebDriverWait(webdriver,Duration.ofSeconds(30));
	    
	    wait2.until(ExpectedConditions.elementToBeClickable(e)).click();
		return e;

}
}
