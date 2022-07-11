package page;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.BrowserManager;

public class List_your_show_page {

	public static WebElement Name;
	public static WebElement Email;
	public static WebElement phone_no;
	public static WebElement Event_Region;
	public static WebElement Event_city;
	static WebDriver webdriver;

	public static WebElement list_Your_Show_link() {
		webdriver = BrowserManager.getDriver();
		// WebElement list_your_show_Element
		// =webdriver.findElement(By.linkText("ListYourShow"));
		WebElement list_your_show_link_Element = webdriver.findElement(By.xpath(("//a[@href='/list-your-show/']")));
		return list_your_show_link_Element;

	}

	// (//p[text()='List your show'])[1]

	public static WebElement list_your_show_button() {
		webdriver = BrowserManager.getDriver();
		// WebElement list_your_show_btn_Element
		// =webdriver.findElement(By.xpath(("(//p[text()='List your show'])[2]")));
		// By.xpath(("(//button[@class='sc-1y2oebh-1 iRpfzT 'and @type='default'])[1]
		webdriver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		WebElement list_your_show_btn_Element = webdriver
				.findElement(By.xpath("(//div//button//span//p[text()='List your show'])[1]"));
		return list_your_show_btn_Element;
	}

	public static WebElement list_your_show_popup() {
		webdriver = BrowserManager.getDriver();
		WebElement list_your_show_popup_Element = webdriver
				.findElement(By.xpath("(//div//button//span//p[text()='List your show'])[3]"));
		return list_your_show_popup_Element;
	}

	public static WebElement enter_name() {
		webdriver = BrowserManager.getDriver();

		WebElement name_Element = webdriver.findElement(By.xpath("//input[@id='name-field']"));
		return name_Element;
	}

	public static WebElement enter_email_id() {
		webdriver = BrowserManager.getDriver();

		WebElement email_Element = webdriver.findElement(By.xpath("//input[@id='email-field']"));
		return email_Element;

	}

	public static WebElement enter_phone_number() {
		webdriver = BrowserManager.getDriver();

		WebElement phone_number_Element = webdriver.findElement(By.xpath("//input[@id='number-field']"));
		return phone_number_Element;

	}

	public static WebElement region_select() {
		webdriver = BrowserManager.getDriver();

		WebElement region_Element = webdriver
				.findElement(By.xpath("//select[@id='region-select']//option[@value='East']"));

		return region_Element;

	}

	public static WebElement city_select() {
		webdriver = BrowserManager.getDriver();
		WebElement city_Element = webdriver
				.findElement(By.xpath("//select[@id='city-select']//option[@value='Bhilai']"));
		return city_Element;
	}

	public static WebElement event_type_select() {
		webdriver = BrowserManager.getDriver();
		WebElement event_type_Element = webdriver
				.findElement(By.xpath("//select[@id='eventtype-select']//option[@value='Workshops']"));
		return event_type_Element;
	}

	public static WebElement expected_audience_select() {
		webdriver = BrowserManager.getDriver();
		WebElement expected_audiance_Element = webdriver
				.findElement(By.xpath("//select[@id='density-select']//option[@value='100 to 1500']"));
		return expected_audiance_Element;
	}

	// select[@id='date-select']//option[@value='Within 15 days']

	public static WebElement date_select() {
		webdriver = BrowserManager.getDriver();
		WebElement date_select_Element = webdriver
				.findElement(By.xpath("//select[@id='date-select']//option[@value='Within 15 days']"));
		return date_select_Element;
	}

	// input[@id='description-field']
	public static WebElement enter_discription() {
		webdriver = BrowserManager.getDriver();
		WebElement enter_discription_Element = webdriver.findElement(By.xpath("//input[@id='description-field']"));
		return enter_discription_Element;
	}

	// div[text()='Submit']
	public static WebElement submit_button() {
		WebElement submit_btn_Element = webdriver.findElement(By.xpath("//div[text()='Submit']"));
		return submit_btn_Element;
	}

	// div[text()='Share']
	public static WebElement share_button() {
		webdriver = BrowserManager.getDriver();
		WebElement share_btn_Element = webdriver.findElement(By.xpath("//div[text()='Share']"));
		return share_btn_Element;
	}
	// (//span[normalize-space()='Twitter'])[1]

	public static WebElement share_on_twitter() {
		webdriver = BrowserManager.getDriver();
		WebElement share_twitter_Element = webdriver.findElement(By.xpath("(//span[normalize-space()='Twitter'])[1]"));
		return share_twitter_Element;
	}

	public static void switch_to_child_window() {
		webdriver = BrowserManager.getDriver();

		String mainWindow = webdriver.getWindowHandle();
		Set<String> set = webdriver.getWindowHandles();
		// Using Iterator to iterate with in windows
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			// Compare whether the main windows is not equal to child window. If not equal,
			// we will close.
			if (!mainWindow.equals(childWindow)) {
				webdriver.switchTo().window(childWindow);
				System.out.println(webdriver.switchTo().window(childWindow).getTitle());
				// webdriver.close();
			}
		}
		// This is to switch to the main window
		// webdriver.switchTo().window(mainWindow);

	}

	// (//input[@name='session[username_or_email]'])[1]
	public static WebElement user_id_twitter() {
		webdriver = BrowserManager.getDriver();
		WebElement login_twitter_Element = webdriver
				.findElement(By.xpath("(//input[@name='session[username_or_email]'])[1]"));
		return login_twitter_Element;
	}

	// (//input[@name='session[password]'])[1]
	public static WebElement passwd_twitter() {
		webdriver = BrowserManager.getDriver();
		WebElement passwd_twitter_Element = webdriver.findElement(By.xpath("(//input[@name='session[password]'])[1]"));
		return passwd_twitter_Element;
	}

	// (//span[text()='Log in'])[2]
	public static WebElement login_btn_twitter() {
		webdriver = BrowserManager.getDriver();
		WebElement login_btn_twitter_Element = webdriver.findElement(By.xpath("(//span[text()='Log in'])[2]"));
		return login_btn_twitter_Element;
	}

	// (//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo
	// r-qvutc0'][normalize-space()='Tweet'])[1]

	public static WebElement tweet_form() {
		webdriver = BrowserManager.getDriver();
		WebElement tweet_Element = webdriver.findElement(By.xpath(
				"(//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0'][normalize-space()='Tweet'])[1]"));
		return tweet_Element;

	}

}