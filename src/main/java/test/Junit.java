package test;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Junit {

	static WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Peter\\AutomationExam\\AutomationExam\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://techfios.com/test/101/");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void toggleAllChecked() {

//		driver.findElement(By.name("allbox")).click();
//
//		WebElement toggleAll = driver.findElement(By.name("allbox"));
		
		driver.findElement(By.xpath("//input[@name='allbox']")).click();
		boolean x = driver.findElement(By.xpath("//input[@name='allbox']")).isSelected();
		
		if (x == true) {
			boolean checkbox1 = driver.findElement(By.name("todo[0]")).isSelected();
			boolean checkbox2 = driver.findElement(By.name("todo[1]")).isSelected();
			boolean checkbox3 = driver.findElement(By.name("todo[2]")).isSelected();
			boolean checkbox4 = driver.findElement(By.name("todo[3]")).isSelected();
			
			if (checkbox1 & checkbox2 & checkbox3 & checkbox4 == true) {
				System.out.println("All checkboxes are toggling with toggle all.");
			}
		} else {
			System.out.println("Toggle all is not checked, so the list items are also not checked as well.");
		}
		
	}
	
	public void removeButton() {

		driver.findElement(By.name("todo[5]")).click();
		
		driver.findElement(By.xpath("//input[@value='Remove']")).click();
		
		System.out.println("An item has been removed");
		

	}


	public void removeAll() {
		
		driver.findElement(By.xpath("//input[@name='allbox']")).click();
		
		driver.findElement(By.xpath("//input[@value='Remove']")).click();
		
		System.out.println("All items in the list have been removed.");

	}

}
