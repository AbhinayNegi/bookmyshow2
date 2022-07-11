package test;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.HomePage;
import page.Home_page;
import page.MoviePage;
import page.PaymentPage;
import page.PrePayPage;
import page.SeatSelectionPage;
import utility.BConfigFileInitialize;
import utility.BrowserManager;
import utility.ClickElement;
import utility.DBManager;
import utility.ScreenshotManager;
import utility.BrowserManager.EPConditions;

public class BookMyShowTest extends BConfigFileInitialize{

	WebDriver driver;
	HomePage homePage;
	MoviePage moviePage;
	SeatSelectionPage seatPage;
	PrePayPage payPage;
	PaymentPage paymentPage;
	String[] movieData;
	
	@BeforeTest
	public void init() throws IOException, SQLException {
		initBrowser();
		BrowserManager.setDriver("Firefox");
		driver = BrowserManager.getDriver();
		driver.manage().window().maximize();
		
		homePage = new HomePage(driver);
		moviePage = new MoviePage(driver);
		seatPage = new SeatSelectionPage(driver);
		payPage = new PrePayPage(driver);
		paymentPage = new PaymentPage(driver);
		
		DBManager dbManager = new DBManager();
		movieData = dbManager.getMovieData();
	}
	
	@Test(priority = 1)
	public void bookTickets() {
		
		driver.get(config.getProperty("bookmyshow.com"));
		
		homePage.getCity().click();
		homePage.getSearchFieldButton().click();
		homePage.getSearchFideld().sendKeys(movieData[0]);
		//homePage.getSearchFideld().sendKeys("Khuda Haafiz Chapter 2 - Agni Pariksha");
		selectMovieFromSuggestions(homePage.getAllSuggestions(), "Bhool Bhulaiyaa 2");
		//selectMovieFromSuggestions(homePage.getAllSuggestions(), "Khuda Haafiz Chapter 2 - Agni Pariksha");
		homePage.getBookTicketButton().click();
		homePage.getNotNowButton().click();
		
		
	}
	
	@Test(dependsOnMethods = "bookTickets")
	public void movieDetails() {
		moviePage.getShowTimeButton().click();
		moviePage.getAcceptButton().click();
		
		selectSeats(moviePage.getSeats(), movieData[1]);
		moviePage.getSelectSeatButton().click();
	}
	
	@Test(dependsOnMethods = "movieDetails")
	public void seatSelection() {
		selectSeat(seatPage.getRows(), movieData[1]);
		
		seatPage.getPayButton().click();
	}
	
	@Test(dependsOnMethods = "seatSelection")
	public void payment() throws IOException {
		payPage.getProceedButton().click();
		WebElement acceptButton = payPage.getAcceptButton();
		if(acceptButton != null) {
			acceptButton.click();
		}
		
		ScreenshotManager.takeScreenshotOf(paymentPage.getPaymentPage(), "Payment page");
	}
	
	@Test(dependsOnMethods = "payment")
	public void loginOTP() {
		driver.get(config.getProperty("bookmyshow.com"));
		
		//ClickElement.btnClick(Home_page.City_selection());
		ClickElement.btnClick(Home_page.Sign_in());
		Home_page.Entermob().sendKeys("enter your number here");
		ClickElement.btnClick(Home_page.Continue_button());
		Home_page.Otp_popup();
		
		
	}
	
	@Test(dependsOnMethods = "loginOTP")
	public void home_page_test() {
		driver.get(config.getProperty("bookmyshow.com"));

		//utility.Click_WebElements.btnClick(Home_page.select_city());
	}

	@Test(dependsOnMethods = "home_page_test")
	public void list_your_show_link_test() {
		utility.Click_WebElements.btnClick(page.List_your_show_page.list_Your_Show_link());
	}

	@Test(dependsOnMethods = "list_your_show_link_test")
	public void form_fill_test() throws InterruptedException, IOException {
		// Click_WebElements.btnClick(List_your_show_page.list_Your_Show_link());
		Thread.sleep(10000);
		// ------------------clicking on the List your show button
		// ----------------------//
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		utility.Click_WebElements.btnClick(page.List_your_show_page.list_your_show_button());
		// ---------Clicking on the list your show pop up
		// -------------------------------//
		utility.Click_WebElements.btnClick(page.List_your_show_page.list_your_show_popup());
		// -------------------entering the name in form
		// ----------------------------------//
		page.List_your_show_page.enter_name().sendKeys("xyzABC");
		// -------------------entering the email id in the form
		// --------------------------//
		page.List_your_show_page.enter_email_id().sendKeys("xyzABC@mailinator.com");
		// ---------------------enter the phone number in the form
		// -----------------------//
		page.List_your_show_page.enter_phone_number().sendKeys("9298150651");

		// ------------------selecting region-------------------//
		utility.Click_WebElements.btnClick(page.List_your_show_page.region_select());
		// ----------------select a city
		// -------------------------------------------------//
		utility.Click_WebElements.btnClick(page.List_your_show_page.city_select());
		// ----------------selecting event type
		// ------------------------------------------//
		utility.Click_WebElements.btnClick(page.List_your_show_page.event_type_select());
		// ----------------selecting expected audience
		// -----------------------------------//
		utility.Click_WebElements.btnClick(page.List_your_show_page.expected_audience_select());
		// ----------------selecting date
		// ------------------------------------------------//
		utility.Click_WebElements.btnClick(page.List_your_show_page.date_select());
		// -------------enter the description
		// -------------------------------------------//
		page.List_your_show_page.enter_discription()
				.sendKeys("This is testing . This is testing .This is testing .This is testing ."
						+ "This is testing .This is testing .This is testing .This is testing .This is testing .This is testing .This is testing ");

		// -------------click on the submit button
		// ---------------------------------------------//
		utility.Click_WebElements.btnClick(page.List_your_show_page.submit_button());
		// ----------------click on the share
		// button----------------------------------------------//
		Thread.sleep(5000);
		utility.Click_WebElements.btnClick(page.List_your_show_page.share_button());
		// ----------------click on share on
		// twitter----------------------------------------------//
		utility.Click_WebElements.btnClick(page.List_your_show_page.share_on_twitter());

		// -----------------switch to child window
		// -----------------------------------------------//
		page.List_your_show_page.switch_to_child_window();

		Thread.sleep(5000);
		// --------------------enter user id in twitter login
		// ------------------------------------//
		page.List_your_show_page.user_id_twitter().sendKeys("enter you twitter username here without @domain.com");

		// -----------------------enter password in twitter login
		// --------------------------------//
		page.List_your_show_page.passwd_twitter().sendKeys("twitter password ");

		// ----------------------click on login
		// button--------------------------------------------//
		utility.Click_WebElements.btnClick(page.List_your_show_page.login_btn_twitter());

		// ---------------------tweet your form
		// -------------------------------------------------//
//		Thread.sleep(5000);
//		utility.Click_WebElements.btnClick(page.List_your_show_page.tweet_form());
		
		//new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='tweetPhoto']//img")));
		WebElement e = BrowserManager.waitFor(By.xpath("//html"), driver, EPConditions.PRESENCE);
		ScreenshotManager.takeScreenshotOf(e, "Tweet");

	}
	
	public void selectSeat(List<WebElement> rows, String s) {
		int seats = Integer.parseInt(s);
		
		int adjacentCounter = 0;
		WebElement firstSeat = null;
		for(int i = 1; i <= rows.size(); i++) {
			adjacentCounter = 0;
			List<WebElement> allSeat = driver.findElements(By.xpath("//table[@class='setmain']//tr["+i+"]//td//div//a"));
			for(WebElement e : allSeat) {
				if(e.getAttribute("class").equals("_available")) {
					if(firstSeat == null) {
						firstSeat = e;
					}
					adjacentCounter++;
					if(adjacentCounter == seats) {
						firstSeat.click();
						return;
					}
				}else {
					adjacentCounter = 0;
					firstSeat = null;
				}
			}
		}
	}
	
	public void selectSeats(List<WebElement> seats, String n) {
		
		for(WebElement e : seats) {
			if(e.getText().equals(n)) {
				e.click();
				break;
			}
		}
	}
	public void selectMovieFromSuggestions(List<WebElement> suggestion,String movieName) {
		for(WebElement e : suggestion) {
			if(e.getAttribute("alt").equals(movieName)) {
				e.click();
				break;
			}
		}
	}
}
