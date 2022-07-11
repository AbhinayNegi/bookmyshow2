package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

public class ScreenshotManager {

	public static void takeScreenshotOf(WebElement element, String name) throws IOException {
		File file = element.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File(System.getProperty("user.dir") + "//screenshots//"+name+".png");
		
		FileUtils.copyFile(file, destFile);
	}
}
