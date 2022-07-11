package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action_Class {

	public static void moveTo(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		
		action.moveToElement(element).perform();
	}
}
