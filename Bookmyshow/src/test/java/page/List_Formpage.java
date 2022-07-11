package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.Base_class;

public class List_Formpage extends Base_class{

	public static WebElement Name;
	public static WebElement Email;
	public static WebElement phone_no;
	public static WebElement Event_Region;
	public static WebElement Event_city;
	public static WebElement Event_type ;
    public static WebElement Event_audience;
	public static WebElement Event_date;
	public static WebElement Event_Description;
	
	public static void Enter_Details() {

		
		
		 Name =webdriver.findElement(By.cssSelector(("#name-field")));
	 Email=webdriver.findElement(By.cssSelector(("#email-field")));
		phone_no=webdriver.findElement(By.cssSelector(("#number-field")));
		
	  }
	
	  public static List<WebElement> Select_region() {
			
       	  List<WebElement> region_list = webdriver.findElements(By.xpath("//select[@id='region-select']"));
			  return region_list;
			
			 }
	  
	
}
