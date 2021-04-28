package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

public class TestNG {

	WebDriver driver;
	String browser = null;

	@BeforeMethod
	public void init() {

		// Setting up the property
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Peter\\AutomationExam\\AutomationExam\\drivers\\chromedriver.exe");
		// Creating web driver instance
		driver = new ChromeDriver();

		// Maximizing Browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// Get to the site
		driver.get("https://techfios.com/test/101/index.php");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority=1)
	public void addCategory() {

		// Element library
		By addCategory = By.name("data");
		By ADD_BUTTON = By.xpath("//input[@value='Add']");

		// Data
		String word = "abc";

		driver.findElement(addCategory).sendKeys(word);
		driver.findElement(ADD_BUTTON).click();

		System.out.println("A category has been added.");
		
	}

	@Test(priority=2)
	public void duplicateCategory() {

		// Element library
		By addCategory = By.name("data");
		By ADD_BUTTON = By.xpath("//input[@value='Add']");
		
		// Data
		String word = "a";
		
		driver.findElement(addCategory).sendKeys(word);
		driver.findElement(ADD_BUTTON).click();
		
		By DUPLICATE_TEXT = By.xpath("//*[contains(text(),'Sorry that TODO item already exist')]");
		
		String duplicateValidationText = driver.findElement(DUPLICATE_TEXT).getText();
		Assert.assertEquals("Sorry that TODO item already exists. Back", duplicateValidationText, "Wrong page!");
		

	}
	
	@Test(priority = 3)
	public void dueDateDropDown() {
		
//		By month = By.name("due_month");
		
		String arr[] = {"None", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		
		Select select = new Select(driver.findElement(By.name("due_month")));
		List<WebElement> dropdownvalues=select.getOptions();
		System.out.println(dropdownvalues.size());
		
		for (int i = 0; i < dropdownvalues.size(); i++) {
			Assert.assertEquals(arr[i], dropdownvalues.get(i).getText());
		}
		
		System.out.println("Verification Succesful");
		driver.close();
	}

}
